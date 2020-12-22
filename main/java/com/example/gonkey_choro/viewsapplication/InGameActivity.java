package com.example.gonkey_choro.viewsapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gonkey_choro.viewsapplication.InventoryClasses.InventoryActivity;
import com.example.gonkey_choro.viewsapplication.NeuralClasses.NeuralFragment;
import com.example.gonkey_choro.viewsapplication.SkillsClasses.SkillsFragment;

import static com.example.gonkey_choro.viewsapplication.ChoosingFragment.CHANGE_MONEY;
import static com.example.gonkey_choro.viewsapplication.MainActivity.PROFILE;

public class InGameActivity extends AppCompatActivity {
    ChoosingFragment cFragm = new ChoosingFragment();
    SkillsFragment sFragm = new SkillsFragment();
    NeuralFragment nFragm = new NeuralFragment();
    ShC pCode;
    Button invButton;
    Context context;
    TextView money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_with_statistics);

        pCode = new ShC(this, PROFILE);
        if(pCode.getInt("GameMode") == 0) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, cFragm)
                    .commit();
        } else if(pCode.getInt("GameMode") == 1) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, sFragm)
                    .commit();
        } else if(pCode.getInt("GameMode") == 2)
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, nFragm)
                    .commit();

        context = this;
        invButton = (Button)findViewById(R.id.inv_button);
        invButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, InventoryActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        TextView theory = (TextView)findViewById(R.id.theory);
        TextView profpract = (TextView)findViewById(R.id.profpract);
        TextView randpract = (TextView)findViewById(R.id.randpract);
        TextView socpract = (TextView)findViewById(R.id.socpract);
        money = (TextView)findViewById(R.id.money);
        theory.setText(String.format("Наемная практика: %s", pCode.getInt("0Level")));
        profpract.setText(String.format("Теоретическое обучение: %s", pCode.getInt("1Level")));
        randpract.setText(String.format("Профессиональная практика: %s", pCode.getInt("2Level")));
        socpract.setText(String.format("Социальная практика: %s", pCode.getInt("3Level")));
        money.setText(String.format("Деньги: %s", pCode.getInt("Money")));
    }

    @Override
    public void onBackPressed() {
        pCode.setInt("GameMode", 0);
        finish();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == CHANGE_MONEY)
            money.setText(String.format("Деньги: %s", pCode.getInt("Money")));
    }
}
