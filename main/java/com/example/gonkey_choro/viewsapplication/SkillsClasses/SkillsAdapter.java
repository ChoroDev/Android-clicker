package com.example.gonkey_choro.viewsapplication.SkillsClasses;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.gonkey_choro.viewsapplication.ShC;
import java.util.ArrayList;
import static com.example.gonkey_choro.viewsapplication.MainActivity.PROFILE;

class SkillsAdapter extends ArrayAdapter<String>{
    private LayoutInflater inflater;
    private int layout;
    private ArrayList<String> itemsList;
    private FragmentActivity activity;
    private ShC pCode;

    SkillsAdapter(Context context, int resource, ArrayList<String> items, FragmentActivity activity) {
        super(context, resource, items);
        this.itemsList = items;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
        this.activity = activity;
        pCode = new ShC(getContext(), PROFILE);
    }

    @NonNull
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {
        final SkillsViewHolder viewHolder;
        if(convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new SkillsViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else viewHolder = (SkillsViewHolder)convertView.getTag();
        viewHolder.text.setText(itemsList.get(position));
        viewHolder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SkillsCalculator(getContext(), PROFILE, activity).counting(position, viewHolder);
            }
        });
        viewHolder.progress.setMax(pCode.getInt(String.valueOf(pCode.getInt(String.valueOf(position)+"Level"))+'.'+String.valueOf(position)+"m"));
        viewHolder.progress.setProgress(pCode.getInt(String.valueOf(pCode.getInt(String.valueOf(position)+"Level"))+'.'+String.valueOf(position)));
        return convertView;
    }
}
