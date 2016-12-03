package com.example.apple.menunavigation;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.CirclePageIndicator;

public class HomeFragment extends Fragment {
    private CirclePageIndicator circlePageIndicator;
    private ViewPager viewPager;
    private ImageAdapter imageAdapter;
    public static final String IMAGE_RESOURCE_ID = "iconResourceID";
    public static final String ITEM_NAME = "itemName";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_home, container, false);
        circlePageIndicator = (CirclePageIndicator)
                rootView.findViewById(R.id.circle_indicator);
        viewPager = (ViewPager) rootView.findViewById(R.id.circle_pager);
        imageAdapter = new ImageAdapter(getFragmentManager());
        viewPager.setAdapter(imageAdapter);

        circlePageIndicator.setRadius(getResources().getDimension(R.dimen.indicator_radius
        ));

        circlePageIndicator.setFillColor(getResources().getColor(R.color.bg_actionbar));
        circlePageIndicator.setViewPager(viewPager);
        return rootView;
    }
}
