package com.example.gonkey_choro.viewsapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.example.gonkey_choro.viewsapplication.BuildingClasses.BuildingOptions;
import com.example.gonkey_choro.viewsapplication.Dialogs.DialogOnExit;
import com.example.gonkey_choro.viewsapplication.Dialogs.DialogOnStartNewGame;
import com.example.gonkey_choro.viewsapplication.Dialogs.DialogRules;
import com.example.gonkey_choro.viewsapplication.NeuralClasses.NeuralOptions;
import com.example.gonkey_choro.viewsapplication.ShopClasses.ShopOptions;

public class MainActivity extends AppCompatActivity {
    Button continue_game;
    public static final String PROFILE = "ProfileSettings";
    public static final String BUILDING = "BuildingOptions";
    public static final String NEURON = "NeuralOptions";
    public static final String SHOP = "ShopOptions";
    public ShC pCode = new ShC(this, PROFILE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            setContentView(R.layout.first_page_2);
        else setContentView(R.layout.first_page_1);
        //to make continue button disabled, turn down next comment
        //pCode.setBool("GameStarted", false);
        pCode.setInt("GameMode", 0);

        continue_game = (Button)findViewById(R.id.continue_game);
        continue_game.setEnabled(pCode.getBool("GameStarted"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        continue_game.setEnabled(pCode.getBool("GameStarted"));
    }

    public void new_game(View view) {
        if(pCode.getBool("GameStarted")) {
            DialogOnStartNewGame startNewGame = new DialogOnStartNewGame();
            startNewGame.show(getSupportFragmentManager(), "new_game");
        } else {
            new DialogRules().show(getSupportFragmentManager(), "rules");
            NeuralOptions.removeAllPreferences(this);
            ProfileOptions.removeAllPreferences(this);
            BuildingOptions.removeAllPreferences(this);
            ShopOptions.removeAllPreferences(this);
            Intent intent = new Intent(this, InGameActivity.class);
            startActivity(intent);
        }
    }

    public void continue_game(View view) {
        Intent intent = new Intent(this, InGameActivity.class);
        startActivity(intent);
    }

    public void rules(View view) {
        new DialogRules().show(getSupportFragmentManager(), "rules");
    }

    public void exit(View view) {
        new DialogOnExit().show(getSupportFragmentManager(), "custom");
    }

    @Override
    public void onBackPressed() {
        new DialogOnExit().show(getSupportFragmentManager(), "custom");
    }
}









