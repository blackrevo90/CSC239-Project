package com.example.apple.menunavigation;

import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Image extends Fragment {
    private static final String IMAGE_ID = "imagesId";
    private static final String POSITION = "position";
    public static Fragment fragment(int position, int imagesId) {
        Image image = new Image();
        Bundle bundle = new Bundle();
        bundle.putInt(POSITION, position);
        bundle.putInt(IMAGE_ID, imagesId);
        image.setArguments(bundle);
        return image;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_image, container, false);
        int imagesId = getArguments().getInt(IMAGE_ID);
        int position = getArguments().getInt(POSITION);
        ImageView imageView = (ImageView) view.findViewById(R.id.news_img);
        imageView.setImageResource(imagesId);
        return view;
    }
}
