package com.example.apple.menunavigation;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class YoutubeFragment extends Fragment {

    private ListView listYoutube;
    private ListViewAdapter listAdapter;
    private YoutubeResult youtube;


    public YoutubeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup youtubeView = (ViewGroup) inflater.inflate(R.layout.fragment_youtube, container, false);
        listYoutube = (ListView) youtubeView.findViewById(R.id.listYoutube);
        listAdapter = new ListViewAdapter();
        listYoutube.setAdapter(listAdapter);
        return youtubeView;
    }

    @Override
    public void onResume() {
        super.onResume();
        new YoutubeFragment.FeedTask().execute("http://www.office365thailand.com/youtube/array_youtube.php");
    }

    private class ListViewAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            if (youtube == null) {
                return 0;
            } else {
                return youtube.getYoutube().size();
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
                view = getActivity().getLayoutInflater().inflate(R.layout.item_listyoutube, null);
                holder = new ViewHolder();
                holder.titleTextView = (TextView) view.findViewById(R.id.item_listview_title);
                holder.authorImageView = (ImageView) view.findViewById(R.id.item_listview_authorIcon);
                holder.youtubeView = (ImageView) view.findViewById(R.id.item_listview_youtube_image);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }

            holder.youtubeView.setTag(R.id.item_listview_youtube_image, i);
            holder.youtubeView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = (int) view.getTag(R.id.item_listview_youtube_image);
                    Intent intent = new Intent(getActivity(), ClickPlayActivity.class);
                    intent.putExtra("VideoID", youtube.getYoutube().get(index).getId());
                    startActivity(intent);
                }
            });

            YoutubeResult.YoutubeBean item = youtube.getYoutube().get(i);
            holder.titleTextView.setText(item.getTitle());

            String authorUrl = item.getLogo();
            Glide.with(getActivity().getApplicationContext()).load(authorUrl)
                    .transform(new CircleTransform(getActivity().getApplicationContext(), "#00000000", 1))
                    .into(holder.authorImageView);

            String imgUrl = item.getImage();
            Glide.with(getActivity().getApplicationContext()).load(imgUrl).into(holder.youtubeView);

            return view;
        }
    }

    public class ViewHolder {
        ImageView authorImageView;
        ImageView youtubeView;
        TextView titleTextView;
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
                Log.i("AAA", e.getMessage());
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
            youtube = gson.fromJson(s, YoutubeResult.class);
            listAdapter.notifyDataSetChanged();
        }
    }
}
