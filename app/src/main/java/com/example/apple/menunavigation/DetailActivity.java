package com.example.apple.menunavigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private TextView menu,direction;
    private ImageView imgFood;
    private String strMenu, strImage , strDirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        menu = (TextView) findViewById(R.id.txt_menu);
        direction = (TextView) findViewById(R.id.txt_direc);
        imgFood = (ImageView) findViewById(R.id.img);

        strMenu = getIntent().getStringExtra("Menu");
        menu.setText(strMenu);

        strImage = getIntent().getStringExtra("Image");
        Glide.with(getApplicationContext()).load(strImage).into(imgFood);

        strDirection = getIntent().getStringExtra("Direction");
        direction.setText(strDirection);
    }
}
