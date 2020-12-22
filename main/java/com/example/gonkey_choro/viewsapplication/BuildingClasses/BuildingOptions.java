package com.example.gonkey_choro.viewsapplication.BuildingClasses;

import android.content.Context;

import com.example.gonkey_choro.viewsapplication.ShC;

import static com.example.gonkey_choro.viewsapplication.MainActivity.BUILDING;

public class BuildingOptions {

    /*--------------------------
    * p - picture
    * t - title
    * c - cost
    * np - random practise
    * to - theory
    * pp - prof practise
    * sp - soc practise
    * can_build - ability for building
    * --------------------------*/

    public static void removeAllPreferences(Context context) {
        ShC bCode = new ShC(context, BUILDING);

        //================================================================================
        //Level of buildings
        //================================================================================

        bCode.setInt("0b_level", 1);
        bCode.setInt("1b_level", 1);
        bCode.setInt("2b_level", 1);
        bCode.setInt("3b_level", 1);

        //================================================================================
        //First level buildings
        //================================================================================

        bCode.setString("b1.0p", "avatarka.png");
        bCode.setString("b1.0t", "Офигевший мышь");
        bCode.setInt("b1.0c", 10000);
        bCode.setInt("b1.0np", 1);
        bCode.setInt("b1.0to", 2);
        bCode.setInt("b1.0pp", 1);
        bCode.setInt("b1.0sp", 1);
        bCode.setInt("b1.0can_build", 1);

        bCode.setString("b1.1p", "");
        bCode.setString("b1.1t", "Второй дом");
        bCode.setInt("b1.1c", 12000);
        bCode.setInt("b1.1np", 1);
        bCode.setInt("b1.1to", 1);
        bCode.setInt("b1.1pp", 2);
        bCode.setInt("b1.1sp", 1);
        bCode.setInt("b1.1can_build", 1);

        bCode.setString("b1.2p", "");
        bCode.setString("b1.2t", "Третий дом");
        bCode.setInt("b1.2c", 11000);
        bCode.setInt("b1.2np", 1);
        bCode.setInt("b1.2to", 1);
        bCode.setInt("b1.2pp", 1);
        bCode.setInt("b1.2sp", 2);
        bCode.setInt("b1.2can_build", 1);

        bCode.setString("b1.3p", "");
        bCode.setString("b1.3t", "Тихий дон");
        bCode.setInt("b1.3c", 15000);
        bCode.setInt("b1.3np", 2);
        bCode.setInt("b1.3to", 1);
        bCode.setInt("b1.3pp", 1);
        bCode.setInt("b1.3sp", 1);
        bCode.setInt("b1.3can_build", 1);

        //================================================================================
        //Another buildings
        //================================================================================
    }
}
