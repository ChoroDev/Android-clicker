package com.example.gonkey_choro.viewsapplication.SkillsClasses;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gonkey_choro.viewsapplication.R;
import com.example.gonkey_choro.viewsapplication.ShC;

import static com.example.gonkey_choro.viewsapplication.MainActivity.SHOP;

class SkillsCalculator {
    private Context context;
    private TextView theory;
    private TextView profpract;
    private TextView randpract;
    private TextView socpract;
    private TextView money;
    private ShC pCode;
    private ShC sCode;

    SkillsCalculator(Context context, String pf, FragmentActivity activity) {
        pCode = new ShC(context, pf);
        sCode = new ShC(context, SHOP);
        this.context = context;
        theory = (TextView)activity.findViewById(R.id.theory);
        profpract = (TextView)activity.findViewById(R.id.profpract);
        randpract = (TextView)activity.findViewById(R.id.randpract);
        socpract = (TextView)activity.findViewById(R.id.socpract);
        money = (TextView)activity.findViewById(R.id.money);
    }

    private String temp_info(int level, int position, int numb, boolean isNotNewLevel, String item) {
        if (isNotNewLevel)
            return pCode.getString(String.valueOf(level)+'.'+position+"t")+'('
                    +String.valueOf(pCode.getInt(String.valueOf(level)+'.'+position+"m")-numb)+')'
                    +" ("+sCode.getInt(item)+')';
        else
            return pCode.getString(String.valueOf(level)+'.'+position+"t")+'('
                    +String.valueOf(pCode.getInt(String.valueOf(level)+'.'+position+"m"))+')'
                    +" ("+sCode.getInt(item)+')';
    }

    private void new_view(boolean isNotNewLevel, int level, int position, int numb, SkillsViewHolder viewHolder, String item) {
        if (isNotNewLevel) {
            pCode.setInt(String.valueOf(level)+'.'+String.valueOf(position), numb);
            sCode.setInt(item, sCode.getInt(item)-1);
            viewHolder.text.setText(temp_info(level, position, numb, true, item));
            viewHolder.progress.setProgress(pCode.getInt(String.valueOf(level)+'.'+String.valueOf(position)));
        } else {
            Toast.makeText(context, "Новый уровень! ("+String.valueOf(level)+')', Toast.LENGTH_LONG).show();
            pCode.setInt(String.valueOf(position)+"Level", level);
            sCode.setInt(item, sCode.getInt(item)-1);
            viewHolder.text.setText(temp_info(level, position, numb, false, item));
            viewHolder.progress.setMax(pCode.getInt(String.valueOf(level)+'.'+String.valueOf(position)+"m"));
            viewHolder.progress.setProgress(0);
            theory.setText(String.format("Наемная практика: %s", pCode.getInt("0Level")));
            profpract.setText(String.format("Теоретическое обучение: %s", pCode.getInt("1Level")));
            randpract.setText(String.format("Профессиональная практика: %s", pCode.getInt("2Level")));
            socpract.setText(String.format("Социальная практика: %s", pCode.getInt("3Level")));
        }
    }

    private void money_subtract(int sum) {
        pCode.setInt("Money", pCode.getInt("Money")-sum);
        money.setText(String.format("Деньги: %s", pCode.getInt("Money")));
    }

    private void money_add(int sum) {
        pCode.setInt("Money", pCode.getInt("Money")+sum);
        money.setText(String.format("Деньги: %s", pCode.getInt("Money")));
    }

    private boolean canIUseItem(String itemPositionInShop) {
        if (sCode.getInt('s'+itemPositionInShop+'s') > 0) {
            return true;
        } else {
            if (sCode.getInt('s'+itemPositionInShop+'v') > 0) {
                sCode.setInt('s'+itemPositionInShop+'v', sCode.getInt('s'+itemPositionInShop+'v')-1);
                sCode.setInt('s'+itemPositionInShop+'s', 100);
                return true;
            } else
                return false;
        }
    }

    void counting(int position, SkillsViewHolder viewHolder) {
        int level = pCode.getInt(String.valueOf(position)+"Level");
        int numb = pCode.getInt(String.valueOf(level)+'.'+String.valueOf(position));

        switch(position) {
            case 0:
                switch(level) {
                case 1: if(numb < 4 && canIUseItem("0.0")) {
                    numb++;
                    new_view(true, level, position, numb, viewHolder, "s0.0s");
                    money_add(10);
                } else if (numb == 4 && canIUseItem("0.0")){
                    level++;
                    new_view(false, level, position, numb, viewHolder, "s0.0s");
                    money_add(25);
                } else
                    Toast.makeText(context, String.format("Вам необходимо: %s", sCode.getString("s0.0i")), Toast.LENGTH_SHORT).show();
                    break;
                case 2: if(numb < 49) {
                    numb++;
                    new_view(true, level, position, numb, viewHolder, "s0.0s");
                    money_add(50);
                } else {
                    level++;
                    new_view(false, level, position, numb, viewHolder, "s0.0s");
                    money_add(150);
                } break;
                case 3: if(numb < 249) {
                    numb++;
                    new_view(true, level, position, numb, viewHolder, "s0.0s");
                    money_add(300);
                } else {
                    level++;
                    new_view(false, level, position, numb, viewHolder, "s0.0s");
                    money_add(500);
                } break;
                case 4: if(numb < 749) {
                    numb++;
                    new_view(true, level, position, numb, viewHolder, "s0.0s");
                    money_add(1000);
                } else {
                    level++;
                    new_view(false, level, position, numb, viewHolder, "s0.0s");
                    money_add(2000);
                } break;
                case 5: if(numb < 1499) {
                    numb++;
                    new_view(true, level, position, numb, viewHolder, "s0.0s");
                    money_add(3000);
                } else
                    Toast.makeText(context, "Достигнут максимальный уровень! ("+String.valueOf(level+1)+')', Toast.LENGTH_LONG).show();
            } break;
            case 1: switch(level) {
                case 1: if (pCode.getInt("Money") - 15 > 0) {
                    if(numb < 9 && canIUseItem("2.0")) {
                        numb++;
                        new_view(true, level, position, numb, viewHolder, "s2.0s");
                        money_subtract(15);
                    }
                    else if (numb == 9 && canIUseItem("2.0")) {
                        level++;
                        new_view(false, level, position, numb, viewHolder, "s2.0s");
                        money_subtract(15);
                    } else Toast.makeText(context, String.format("Вам необходимо: %s", sCode.getString("s2.0i")), Toast.LENGTH_SHORT).show();
                } else Toast.makeText(context, "Недостаточно денег!", Toast.LENGTH_SHORT).show();
                    break;
                case 2: if(numb < 99 && pCode.getInt("Money") - 75 > 0) {
                    numb++;
                    new_view(true, level, position, numb, viewHolder, "s0.0s");
                    money_subtract(75);
                } else if (pCode.getInt("Money") - 75 > 0){
                    level++;
                    new_view(false, level, position, numb, viewHolder, "s0.0s");
                    money_subtract(75);
                } else Toast.makeText(context, "Недостаточно денег!", Toast.LENGTH_SHORT).show();
                    break;
                case 3: if(numb < 499 && pCode.getInt("Money") - 450 > 0) {
                    numb++;
                    new_view(true, level, position, numb, viewHolder, "s0.0s");
                    money_subtract(450);
                } else if (pCode.getInt("Money") - 450 > 0){
                    level++;
                    new_view(false, level, position, numb, viewHolder, "s0.0s");
                    money_subtract(450);
                } else Toast.makeText(context, "Недостаточно денег!", Toast.LENGTH_SHORT).show();
                    break;
                case 4: if(numb < 1499 && pCode.getInt("Money") - 1500 > 0) {
                    numb++;
                    new_view(true, level, position, numb, viewHolder, "s0.0s");
                    money_subtract(1500);
                } else if (pCode.getInt("Money") - 1500 > 0){
                    level++;
                    new_view(false, level, position, numb, viewHolder, "s0.0s");
                    money_subtract(1500);
                } else Toast.makeText(context, "Недостаточно денег!", Toast.LENGTH_SHORT).show();
                    break;
                case 5: if(numb < 2999 && pCode.getInt("Money") - 4500 > 0) {
                    numb++;
                    new_view(true, level, position, numb, viewHolder, "s0.0s");
                    money_subtract(4500);
                } else if (numb == 2999)
                    Toast.makeText(context, "Достигнут максимальный уровень! ("+String.valueOf(level+1)+')', Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(context, "Недостаточно денег!", Toast.LENGTH_SHORT).show();
            } break;
            case 2: switch(level) {
                case 1: if(numb < 24 && canIUseItem("1.0")) {
                    numb++;
                    new_view(true, level, position, numb, viewHolder, "s1.0s");
                    money_add(10);
                } else if (numb == 24 && canIUseItem("1.0")){
                    level++;
                    new_view(false, level, position, numb, viewHolder, "s1.0s");
                    money_add(20);
                } else Toast.makeText(context, String.format("Вам необходимо: %s", sCode.getString("s1.0i")), Toast.LENGTH_SHORT).show();
                    break;
                case 2: if(numb < 199) {
                    numb++;
                    new_view(true, level, position, numb, viewHolder, "s0.0s");
                    money_add(40);
                } else {
                    level++;
                    new_view(false, level, position, numb, viewHolder, "s0.0s");
                    money_add(100);
                } break;
                case 3: if(numb < 1399) {
                    numb++;
                    new_view(true, level, position, numb, viewHolder, "s0.0s");
                    money_add(200);
                } else {
                    level++;
                    new_view(false, level, position, numb, viewHolder, "s0.0s");
                    money_add(400);
                } break;
                case 4: if(numb < 3999) {
                    numb++;
                    new_view(true, level, position, numb, viewHolder, "s0.0s");
                    money_add(700);
                } else {
                    level++;
                    new_view(false, level, position, numb, viewHolder, "s0.0s");
                    money_add(1500);
                } break;
                case 5: if(numb < 9999) {
                    numb++;
                    new_view(true, level, position, numb, viewHolder, "s0.0s");
                    money_add(2000);
                } else
                    Toast.makeText(context, "Достигнут максимальный уровень! ("+String.valueOf(level+1)+')', Toast.LENGTH_LONG).show();
            } break;
            case 3: switch(level) {
                case 1: if(numb < 19 && canIUseItem("3.0")) {
                    numb++;
                    new_view(true, level, position, numb, viewHolder, "s3.0s");
                    money_add(5);
                } else if (numb == 19 && canIUseItem("3.0")){
                    level++;
                    new_view(false, level, position, numb, viewHolder, "s3.0s");
                    money_add(15);
                } else Toast.makeText(context, String.format("Вам необходимо: %s", sCode.getString("s3.0i")), Toast.LENGTH_SHORT).show();
                    break;
                case 2: if(numb < 169) {
                    numb++;
                    new_view(true, level, position, numb, viewHolder, "s0.0s");
                    money_add(25);
                } else {
                    level++;
                    new_view(false, level, position, numb, viewHolder, "s0.0s");
                    money_add(40);
                } break;
                case 3: if(numb < 1199) {
                    numb++;
                    new_view(true, level, position, numb, viewHolder, "s0.0s");
                    money_add(80);
                } else {
                    level++;
                    new_view(false, level, position, numb, viewHolder, "s0.0s");
                    money_add(150);
                } break;
                case 4: if(numb < 2999) {
                    numb++;
                    new_view(true, level, position, numb, viewHolder, "s0.0s");
                    money_add(300);
                } else {
                    level++;
                    new_view(false, level, position, numb, viewHolder, "s0.0s");
                    money_add(500);
                } break;
                case 5: if(numb < 7999) {
                    numb++;
                    new_view(true, level, position, numb, viewHolder, "s0.0s");
                    money_add(700);
                } else
                    Toast.makeText(context, "Достигнут максимальный уровень! ("+String.valueOf(level+1)+')', Toast.LENGTH_LONG).show();
            } break;
        }
    }
}
