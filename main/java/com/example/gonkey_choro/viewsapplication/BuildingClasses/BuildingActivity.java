package com.example.gonkey_choro.viewsapplication.BuildingClasses;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.example.gonkey_choro.viewsapplication.R;

public class BuildingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.building_activity);

        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(new BuildingAdapter(getSupportFragmentManager(), this));
    }
}
