package com.example.gonkey_choro.viewsapplication.ShopClasses;

import android.content.Context;

import com.example.gonkey_choro.viewsapplication.R;
import com.example.gonkey_choro.viewsapplication.ShC;

import static com.example.gonkey_choro.viewsapplication.MainActivity.SHOP;

public class ShopOptions {
    /*--------------------
    * c - cost
    * i - information
    * p - picture
    * count - count of visible elements
    * v - count of elements i have
    * s - strength of item
    * m_c - is money changed
    * --------------------
    * */

    public static void removeAllPreferences(Context context) {
        ShC sCode = new ShC(context, SHOP);
        sCode.setBool("m_c", false);
        sCode.setInt("s_all.count", 4);

        //================================================================================
        //Tools
        //================================================================================

        sCode.setInt("s0.count", 3);

        sCode.setString("s0.0i", "Лопата");
        sCode.setInt("s0.0c", 100);
        sCode.setInt("s0.0v", 0);
        sCode.setInt("s0.0p", R.drawable.avatarka);
        sCode.setInt("s0.0s", 0);

        sCode.setString("s0.1i", "Топор");
        sCode.setInt("s0.1c", 150);
        sCode.setInt("s0.1v", 0);
        sCode.setInt("s0.1p", R.drawable.avatarka);
        sCode.setInt("s0.1s", 0);

        sCode.setString("s0.2i", "Третий инструмент");
        sCode.setInt("s0.2c", 500);
        sCode.setInt("s0.2v", 0);
        sCode.setInt("s0.2p", R.drawable.avatarka);
        sCode.setInt("s0.2s", 0);

        //================================================================================
        //Materials
        //================================================================================

        sCode.setInt("s1.count", 3);

        sCode.setString("s1.0i", "Первый материал");
        sCode.setInt("s1.0c", 50);
        sCode.setInt("s1.0v", 0);
        sCode.setInt("s1.0p", R.drawable.avatarka);
        sCode.setInt("s1.0s", 0);

        sCode.setString("s1.1i", "Второй материал");
        sCode.setInt("s1.1c", 150);
        sCode.setInt("s1.1v", 0);
        sCode.setInt("s1.1p", R.drawable.avatarka);
        sCode.setInt("s1.1s", 0);

        sCode.setString("s1.2i", "Третий материал");
        sCode.setInt("s1.2c", 250);
        sCode.setInt("s1.2v", 0);
        sCode.setInt("s1.2p", R.drawable.avatarka);
        sCode.setInt("s1.2s", 0);

        //================================================================================
        //Books
        //================================================================================

        sCode.setInt("s2.count", 3);

        sCode.setString("s2.0i", "Азбука");
        sCode.setInt("s2.0c", 50);
        sCode.setInt("s2.0v", 0);
        sCode.setInt("s2.0p", R.drawable.avatarka);
        sCode.setInt("s2.0s", 0);

        sCode.setString("s2.1i", "Комплект книг для учебы в колледже");
        sCode.setInt("s2.1c", 750);
        sCode.setInt("s2.1v", 0);
        sCode.setInt("s2.1p", R.drawable.avatarka);
        sCode.setInt("s2.1s", 0);

        sCode.setString("s2.2i", "Третья книга");
        sCode.setInt("s2.2c", 1050);
        sCode.setInt("s2.2v", 0);
        sCode.setInt("s2.2p", R.drawable.avatarka);
        sCode.setInt("s2.2s", 0);

        //================================================================================
        //Toys
        //================================================================================

        sCode.setInt("s3.count", 3);

        sCode.setString("s3.0i", "Маленький плюшевый медведь");
        sCode.setInt("s3.0c", 20);
        sCode.setInt("s3.0v", 0);
        sCode.setInt("s3.0p", R.drawable.avatarka);
        sCode.setInt("s3.0s", 0);

        sCode.setString("s3.1i", "Машинка");
        sCode.setInt("s3.1c", 30);
        sCode.setInt("s3.1v", 0);
        sCode.setInt("s3.1p", R.drawable.avatarka);
        sCode.setInt("s3.1s", 0);

        sCode.setString("s3.2i", "Рабочие перчатки");
        sCode.setInt("s3.2c", 10);
        sCode.setInt("s3.2v", 0);
        sCode.setInt("s3.2p", R.drawable.avatarka);
        sCode.setInt("s3.2s", 0);

        //================================================================================
        //Upgrades
        //================================================================================
    }
}
