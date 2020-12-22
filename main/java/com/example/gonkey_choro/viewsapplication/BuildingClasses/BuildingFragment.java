package com.example.gonkey_choro.viewsapplication.BuildingClasses;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gonkey_choro.viewsapplication.R;
import com.example.gonkey_choro.viewsapplication.ShC;
import java.io.IOException;
import java.io.InputStream;
import static com.example.gonkey_choro.viewsapplication.MainActivity.BUILDING;
import static com.example.gonkey_choro.viewsapplication.MainActivity.PROFILE;

public class BuildingFragment extends Fragment {
    private int page_numb;
    ShC b_code;
    ShC p_code;

    public static BuildingFragment newInstance(int page) {
        BuildingFragment fragment = new BuildingFragment();
        Bundle args = new Bundle();
        args.putInt("page_number", page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page_numb = getArguments() != null ? getArguments().getInt("page_number") : 1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.building_listing, container, false);
        ImageView image = (ImageView)view.findViewById(R.id.building_image);
        Button buildButton = (Button)view.findViewById(R.id.build_button);
        TextView money_and_skills = (TextView)view.findViewById(R.id.money_and_skills);
        TextView req_skills = (TextView)view.findViewById(R.id.skills_required);
        TextView building_cost = (TextView)view.findViewById(R.id.building_cost);
        b_code = new ShC(getContext(), BUILDING);
        p_code = new ShC(getContext(), PROFILE);
        int[] rsk = new int[5];
        int[] bsk = new int[5];
        rsk[0] = p_code.getInt("Money");
        rsk[1] = p_code.getInt("0Level");
        rsk[2] = p_code.getInt("1Level");
        rsk[3] = p_code.getInt("2Level");
        rsk[4] = p_code.getInt("3Level");
        bsk[0] = b_code.getInt('b'+String.valueOf(b_code.getInt(String.valueOf(page_numb)+"b_level"))+'.'+String.valueOf(page_numb)+"c");
        bsk[1] = b_code.getInt('b'+String.valueOf(b_code.getInt(String.valueOf(page_numb)+"b_level"))+'.'+String.valueOf(page_numb)+"np");
        bsk[2] = b_code.getInt('b'+String.valueOf(b_code.getInt(String.valueOf(page_numb)+"b_level"))+'.'+String.valueOf(page_numb)+"to");
        bsk[3] = b_code.getInt('b'+String.valueOf(b_code.getInt(String.valueOf(page_numb)+"b_level"))+'.'+String.valueOf(page_numb)+"pp");
        bsk[4] = b_code.getInt('b'+String.valueOf(b_code.getInt(String.valueOf(page_numb)+"b_level"))+'.'+String.valueOf(page_numb)+"sp");

        money_and_skills.setText(String.format("Деньги: %s\n(наем. практ.: %s, теор.: %s, проф. практ.: %s, соц. практ.: %s)",
                rsk[0], rsk[1], rsk[2], rsk[3], rsk[4]));
        String image_name = b_code.getString('b'+String.valueOf(b_code.getInt(String.valueOf(page_numb)+"b_level"))+'.'+String.valueOf(page_numb)+"p");
        req_skills.setText(String.format("Необходимые навыки:\n н.п.: %s, т.о.: %s, п.п.: %s, с.п.: %s", bsk[1], bsk[2], bsk[3], bsk[4]));
        if (rsk[1] >= bsk[1] && rsk[2] >= bsk[2] && rsk[3] >= bsk[3] && rsk[4] >= bsk[4]) {
            req_skills.setTextColor(Color.GREEN);
            b_code.setInt('b'+String.valueOf(b_code.getInt(String.valueOf(page_numb)+"b_level"))+'.'+String.valueOf(page_numb)+"can_build", 1);
        }
        else {
            req_skills.setTextColor(Color.RED);
            b_code.setInt('b'+String.valueOf(b_code.getInt(String.valueOf(page_numb)+"b_level"))+'.'+String.valueOf(page_numb)+"can_build", 2);
        }
        building_cost.setText(String.format("Цена: %s", bsk[0]));
        if (rsk[0] >= bsk[0] && b_code.getInt('b'+String.valueOf(b_code.getInt(String.valueOf(page_numb)+"b_level"))+'.'+String.valueOf(page_numb)+"can_build") == 1) {
            building_cost.setTextColor(Color.GREEN);
            b_code.setInt('b'+String.valueOf(b_code.getInt(String.valueOf(page_numb)+"b_level"))+'.'+String.valueOf(page_numb)+"can_build", 0);
        }
        else if (rsk[0] >= bsk[0])
            building_cost.setTextColor(Color.GREEN);
        else
            building_cost.setTextColor(Color.RED);

        buildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b_code.getInt('b'+String.valueOf(b_code.getInt(String.valueOf(page_numb)+"b_level"))+'.'+String.valueOf(page_numb)+"can_build") == 0)
                    Toast.makeText(getContext(), "Можно строить", Toast.LENGTH_SHORT).show();
                else if (b_code.getInt('b'+String.valueOf(b_code.getInt(String.valueOf(page_numb)+"b_level"))+'.'+String.valueOf(page_numb)+"can_build") == 1)
                    Toast.makeText(getContext(), "Не достаточно денег", Toast.LENGTH_SHORT).show();
                else if (b_code.getInt('b'+String.valueOf(b_code.getInt(String.valueOf(page_numb)+"b_level"))+'.'+String.valueOf(page_numb)+"can_build") == 2)
                    Toast.makeText(getContext(), "Слабые навыки", Toast.LENGTH_SHORT).show();
            }
        });

        InputStream inputStream = null;
        try {
            inputStream = getContext().getAssets().open(image_name);
            Drawable d = Drawable.createFromStream(inputStream, null);
            image.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return view;
    }
}
