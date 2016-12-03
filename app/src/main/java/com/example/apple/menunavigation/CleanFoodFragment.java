package com.example.apple.menunavigation;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CleanFoodFragment extends Fragment {

    private ListView listView;
    private ListViewAdapter listAdapter;
    private FoodResult foodResult;



    public CleanFoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup foodView1 = (ViewGroup) inflater.inflate(R.layout.fragment_clean_food, container, false);
        listView = (ListView) foodView1.findViewById(R.id.listView);
        listAdapter = new ListViewAdapter();
        listView.setAdapter(listAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                FoodResult.FoodsBean foodID = foodResult.getFoods().get(position);
                intent.putExtra("Menu",foodID.getMenu());
                intent.putExtra("Image",foodID.getFood_img());
                intent.putExtra("Direction",foodID.getDirections());
                startActivity(intent);
            }
        });
        return foodView1;
    }

    @Override
    public void onResume() {
        super.onResume();
        new FeedTask().execute("http://www.office365thailand.com/food/array_food.php");
    }

    public class ViewHolder {
        ImageView foodImageView;
        TextView titleTextView;
    }

    private class ListViewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            if(foodResult == null){
                return 0;
            }else {
                return foodResult.getFoods().size();
            }
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder = null;
            if (view == null) {
                view = getActivity().getLayoutInflater().inflate(R.layout.item_listview, null);
                holder = new ViewHolder();
                holder.foodImageView = (ImageView) view.findViewById(R.id.item_img);
                holder.titleTextView = (TextView) view.findViewById(R.id.item_title);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }

            FoodResult.FoodsBean item = foodResult.getFoods().get(i);



            holder.titleTextView.setText(item.getMenu());
            String imgUrl = item.getFood_img();
            Glide.with(getActivity().getApplicationContext()).load(imgUrl)
                    .transform(new CircleTransform(getActivity().getApplicationContext(),"#00000000",3))
                    .into(holder.foodImageView);

            // Circle Transform
           /* String imgUrl = "http://www.provincia.com.mx/px/widgets/tecnologia/imageupload/provincia_201561_2036082359.png?อะไรก็ได้";
            Glide.with(getApplicationContext()).load(imgUrl)
                    .transform(new CircleTransform(getApplicationContext(), "#00000000", 3))
                    .into(holder.foodImageView);*/

            /*holder.foodImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = (int) v.getTag(R.id.item_img);
                    Intent intent = new Intent(getActivity(), DetailActivity.class);
                    FoodResult.FoodsBean foodID = foodResult.getFoods().get(index);
                    intent.putExtra("Menu",foodID.getMenu());
                    intent.putExtra("Image",foodID.getFood_img());
                    intent.putExtra("Direction",foodID.getDirections());
                    startActivity(intent);
                }
            });*/

            return view;
        }
    }

    public class FeedTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            Log.i("AAA", "doInBackground");
            OkHttpClient client = new OkHttpClient();
            okhttp3.Request request = new Request.Builder()
                    .url(strings[0])
                    .build();

            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                Log.i("AAA",e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.i("AAA", "onPreExecute");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.i("AAA", "onPostExecute");

            Gson gson = new Gson();
            foodResult = gson.fromJson(s, FoodResult.class);
            listAdapter.notifyDataSetChanged();
        }
    }


}
