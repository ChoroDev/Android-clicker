package com.example.gonkey_choro.viewsapplication.BuildingClasses;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import static android.content.Context.MODE_PRIVATE;
import static com.example.gonkey_choro.viewsapplication.MainActivity.BUILDING;

class BuildingAdapter extends FragmentStatePagerAdapter {
    private Context context;
    BuildingAdapter(FragmentManager manager, Context context) {
        super(manager);
        this.context = context;
    }

    @Override
    public int getCount() {
        return(4);
    }

    @Override
    public Fragment getItem(int position) {
        return(BuildingFragment.newInstance(position));
    }

    public String getPageTitle(int position) {
        return(context.getSharedPreferences(BUILDING, MODE_PRIVATE).getString("b"+String.valueOf(
                context.getSharedPreferences(BUILDING, MODE_PRIVATE).getInt(String.valueOf(position)+"b_level", 1))+"."+String.valueOf(position)+"t",
                "Error"));
    }
}
