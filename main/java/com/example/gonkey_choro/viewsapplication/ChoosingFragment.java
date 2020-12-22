package com.example.gonkey_choro.viewsapplication;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.gonkey_choro.viewsapplication.BuildingClasses.BuildingActivity;
import com.example.gonkey_choro.viewsapplication.NeuralClasses.NeuralFragment;
import com.example.gonkey_choro.viewsapplication.ShopClasses.ShopActivity;
import com.example.gonkey_choro.viewsapplication.SkillsClasses.SkillsFragment;
import static android.content.Context.MODE_PRIVATE;
import static com.example.gonkey_choro.viewsapplication.MainActivity.PROFILE;

public class ChoosingFragment extends Fragment {
    ChoosingFragment fragment = this;
    View view = null;
    ShC pCode;
    TextView money;
    public static int CHANGE_MONEY = 1;
    public static int EXIT_FROM_ACTIVITY = 2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        if(view == null)
            view = inflater.inflate(R.layout.choosing_fragment, container, false);
        else ((ViewGroup)view.getParent()).removeView(view);
        Button goto_button = (Button)view.findViewById(R.id.goto_list);
        goto_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSharedPreferences(PROFILE, MODE_PRIVATE).edit().putInt("GameMode", 1).apply();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .remove(fragment)
                        .add(R.id.container, new SkillsFragment())
                        .commit();
            }
        });
        Button main_m = (Button)view.findViewById(R.id.main_menu_button_ch_fr);
        main_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        Button building = (Button)view.findViewById(R.id.building);
        building.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), BuildingActivity.class);
                startActivity(intent);
            }
        });
        Button neural = (Button)view.findViewById(R.id.neural);
        neural.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSharedPreferences(PROFILE, MODE_PRIVATE).edit().putInt("GameMode", 2).apply();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .remove(fragment)
                        .add(R.id.container, new NeuralFragment())
                        .commit();
            }
        });
        Button shop = (Button)view.findViewById(R.id.shop);
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int req = 0;
                Intent intent = new Intent(getContext(), ShopActivity.class);
                startActivityForResult(intent, req);
                pCode = new ShC(getContext(), PROFILE);

            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == EXIT_FROM_ACTIVITY)
            getActivity().onBackPressed();
        else if (resultCode == CHANGE_MONEY) {
            money = (TextView) getActivity().findViewById(R.id.money);
            money.setText(String.format("Деньги: %s", pCode.getInt("Money")));
        } else super.onActivityResult(requestCode, resultCode, data);
    }
}
