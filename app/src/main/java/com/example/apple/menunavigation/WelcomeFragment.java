package com.example.apple.menunavigation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {

    final static String LAYOUT_ID = "layoutID";

    public WelcomeFragment() {
        // Required empty public constructor
    }

    public static WelcomeFragment newInstance(int layoutID) {

        WelcomeFragment fragment = new WelcomeFragment();
        Bundle args = new Bundle();
        args.putInt(LAYOUT_ID,layoutID);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(getArguments().getInt(LAYOUT_ID,-1),container,false);
        return root;
        //return inflater.inflate(R.layout.fragment_welcome, container, false);
    }

}
