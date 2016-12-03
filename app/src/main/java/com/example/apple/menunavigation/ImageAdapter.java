package com.example.apple.menunavigation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ImageAdapter extends FragmentPagerAdapter {
    int[] imagesId = {R.drawable.n1, R.drawable.n2};
    int position = imagesId.length;

    public ImageAdapter(FragmentManager fm) {
        super(fm);
    }

    public Fragment getItem(int position) {
        return Image.fragment(position,imagesId[position]);
    }

    @Override
    public int getCount() {
        return position;
    }
}
