package com.example.gonkey_choro.viewsapplication;

import android.content.Context;

import static com.example.gonkey_choro.viewsapplication.MainActivity.PROFILE;

public class ProfileOptions {

    /*PROFILE has settings:
    * GameStarted - boolean for button continue_game
    * ProfileName - String for name of profile
    * --------------------------
    * t - text
    * m - maximal count of skill increasing
    * --------------------------
    * For all int settings should be defined pictures*/

    public static void removeAllPreferences(Context context) {
        ShC pCode = new ShC(context, PROFILE);
        pCode.setInt("GameMode", 0);
        pCode.setBool("GameStarted", true);
        pCode.setString("ProfileName", "player");

        //================================================================================
        //Levels for skills
        //================================================================================

        pCode.setInt("0Level", 1);
        pCode.setInt("1Level", 1);
        pCode.setInt("2Level", 1);
        pCode.setInt("3Level", 1);

        //================================================================================
        //money
        //================================================================================

        pCode.setInt("Money", 2000);

        //================================================================================
        //JOBS/EDUCATION
        //================================================================================
        //first level jobs/education
        //================================================================================

        pCode.setInt("1.0", 0);
        pCode.setString("1.0t", "Копать яму (н.п.)");// (0-5)
        pCode.setInt("1.0m", 5);

        pCode.setInt("1.1", 0);
        pCode.setString("1.1t", "Читать книги (т.о.)");// (0-10)
        pCode.setInt("1.1m", 10);

        pCode.setInt("1.2", 0);
        pCode.setString("1.2t", "Рубить дрова (п.п.)");// (0-25)
        pCode.setInt("1.2m", 25);

        pCode.setInt("1.3", 0);
        pCode.setString("1.3t", "Нянчить ребенка (с.п.)");// (0-20)
        pCode.setInt("1.3m", 20);

        //================================================================================
        //second level jobs/education
        //================================================================================

        pCode.setInt("2.0", 0);
        pCode.setString("2.0t", "Работать в огороде (н.п.)");// (5-50)
        pCode.setInt("2.0m", 50);

        pCode.setInt("2.1", 0);
        pCode.setString("2.1t", "Учиться в колледже (т.о.)");// (10-100)
        pCode.setInt("2.1m", 100);

        pCode.setInt("2.2", 0);
        pCode.setString("2.2t", "Работать в мастерской (п.п.)");// (25-200)
        pCode.setInt("2.2m", 200);

        pCode.setInt("2.3", 0);
        pCode.setString("2.3t", "Работать в детском саду (с.п.)");// (20-170)
        pCode.setInt("2.3m", 170);

        //================================================================================
        //third level jobs/education
        //================================================================================

        pCode.setInt("3.0", 0);
        pCode.setString("3.0t", "Работать на ферме (н.п.)");// (50-250)
        pCode.setInt("3.0m", 250);

        pCode.setInt("3.1", 0);
        pCode.setString("3.1t", "Учиться в академии (т.о.)");// (100-500)
        pCode.setInt("3.1m", 500);

        pCode.setInt("3.2", 0);
        pCode.setString("3.2t", "Работать на заводе (п.п.)");// (200-1400)
        pCode.setInt("3.2m", 1400);

        pCode.setInt("3.3", 0);
        pCode.setString("3.3t", "Работать учителем (с.п.)");// (170-1200)
        pCode.setInt("3.3m", 1200);

        //================================================================================
        //fourth level jobs/education
        //================================================================================

        pCode.setInt("4.0", 0);
        pCode.setString("4.0t", "Работать личным охранником (н.п.)");// (250-750)
        pCode.setInt("4.0m", 750);

        pCode.setInt("4.1", 0);
        pCode.setString("4.1t", "Обучаться по курсам (т.о.)");// (500-1500)
        pCode.setInt("4.1m", 1500);

        pCode.setInt("4.2", 0);
        pCode.setString("4.2t", "Работать начальником небольшого бизнеса (п.п.)");// (1400-4000)
        pCode.setInt("4.2m", 4000);

        pCode.setInt("4.3", 0);
        pCode.setString("4.3t", "Работать социологом (с.п.)");// (1200-3000)
        pCode.setInt("4.3m", 3000);

        //================================================================================
        //fifth level jobs/education
        //================================================================================

        pCode.setInt("5.0", 0);
        pCode.setString("5.0t", "Работать охранником при президенте (н.п.)");// (750-1500)
        pCode.setInt("5.0m", 750);

        pCode.setInt("5.1", 0);
        pCode.setString("5.1t", "Учиться в ВУЗе (т.о.)");// (1500-3000)
        pCode.setInt("5.1m", 3000);

        pCode.setInt("5.2", 0);
        pCode.setString("5.2t", "Работать начальником большой фирмы (п.п.)");// (4000-10000)
        pCode.setInt("5.2m", 10000);

        pCode.setInt("5.3", 0);
        pCode.setString("5.3t", "Работать политологом (с.п.)");// (3000-8000)
        pCode.setInt("5.3m", 8000);
    }
}
