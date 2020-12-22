package com.example.gonkey_choro.viewsapplication.SkillsClasses;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.gonkey_choro.viewsapplication.ChoosingFragment;
import com.example.gonkey_choro.viewsapplication.R;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static com.example.gonkey_choro.viewsapplication.MainActivity.PROFILE;

public class SkillsFragment extends Fragment {
    private int temp_value(int level, String suffix) {
        return getActivity().getSharedPreferences(PROFILE, MODE_PRIVATE).getInt(String.valueOf(level)+suffix+"m",0)
                -getActivity().getSharedPreferences(PROFILE, MODE_PRIVATE).getInt(String.valueOf(level)+suffix,0);
    }

    private String temp_info(int level, String suffix) {
        return getActivity().getSharedPreferences(PROFILE, MODE_PRIVATE)
                .getString(String.valueOf(level)+suffix+"t", "")+'('+String.valueOf(temp_value(level, suffix))+')';
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        ArrayList<String> skills = new ArrayList<>();
        ListView skillsList;
        int level;

        //================================================================================
        //Calculating values of skill progress and adding to the list
        //================================================================================

        if(skills.size() == 0) {
            level = getActivity().getSharedPreferences(PROFILE, MODE_PRIVATE).getInt("0Level", 1);
            skills.add(temp_info(level, ".0"));

            level = getActivity().getSharedPreferences(PROFILE, MODE_PRIVATE).getInt("1Level", 1);
            skills.add(temp_info(level, ".1"));

            level = getActivity().getSharedPreferences(PROFILE, MODE_PRIVATE).getInt("2Level", 1);
            skills.add(temp_info(level, ".2"));

            level = getActivity().getSharedPreferences(PROFILE, MODE_PRIVATE).getInt("3Level", 1);
            skills.add(temp_info(level, ".3"));
        }


        //================================================================================
        //Listener for back_button
        //================================================================================

        Button back_button = (Button)view.findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSharedPreferences(PROFILE, MODE_PRIVATE).edit().putInt("GameMode", 0).apply();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new ChoosingFragment())
                        .commit();
            }
        });

        //================================================================================
        //Listener for main_menu_button
        //================================================================================

        Button main_menu = (Button) view.findViewById(R.id.main_menu_button);
        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        //================================================================================
        //
        //================================================================================

        skillsList = (ListView)view.findViewById(R.id.skills_list);
        SkillsAdapter adapter = new SkillsAdapter(getContext(), R.layout.skills_on_game, skills, getActivity());
        skillsList.setAdapter(adapter);

        return view;
    }
}
