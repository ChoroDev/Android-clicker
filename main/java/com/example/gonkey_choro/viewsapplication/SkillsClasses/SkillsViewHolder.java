package com.example.gonkey_choro.viewsapplication.SkillsClasses;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.gonkey_choro.viewsapplication.R;

class SkillsViewHolder {
    final Button plus;
    final TextView text;
    final ProgressBar progress;

    SkillsViewHolder(View view) {
        plus = (Button)view.findViewById(R.id.button_text);
        text = (TextView)view.findViewById(R.id.item_text);
        progress = (ProgressBar)view.findViewById(R.id.progress_skills);
    }
}
