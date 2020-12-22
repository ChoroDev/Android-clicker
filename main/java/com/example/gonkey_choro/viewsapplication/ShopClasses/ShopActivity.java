package com.example.gonkey_choro.viewsapplication.ShopClasses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gonkey_choro.viewsapplication.R;
import com.example.gonkey_choro.viewsapplication.ShC;

import static com.example.gonkey_choro.viewsapplication.ChoosingFragment.CHANGE_MONEY;
import static com.example.gonkey_choro.viewsapplication.MainActivity.PROFILE;

public class ShopActivity extends AppCompatActivity {
    Button tools;
    Button materials;
    Button books;
    Button rand;
    Button upgrades;
    Button toMainMenu;
    TextView money;
    ShC pCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_activity);
        pCode = new ShC(this, PROFILE);

        tools = (Button)findViewById(R.id.shop_tools);
        materials = (Button)findViewById(R.id.shop_materials);
        books = (Button)findViewById(R.id.shop_books);
        rand = (Button)findViewById(R.id.shop_random_things);
        upgrades = (Button)findViewById(R.id.shop_upgrades);
        toMainMenu = (Button)findViewById(R.id.shop_to_main_menu);
        money = (TextView)findViewById(R.id.shop_money);
        money.setText(String.format("Деньги: %s", pCode.getInt("Money")));

        tools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShopItemsActivity.class);
                intent.putExtra("section", 0);
                startActivityForResult(intent, 0);
            }
        });
        materials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShopItemsActivity.class);
                intent.putExtra("section", 1);
                startActivityForResult(intent, 0);
            }
        });
        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShopItemsActivity.class);
                intent.putExtra("section", 2);
                startActivityForResult(intent, 0);
            }
        });
        rand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShopItemsActivity.class);
                intent.putExtra("section", 3);
                startActivityForResult(intent, 0);
            }
        });
        upgrades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tools.callOnClick();
            }
        });
        toMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(2);
                finish();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == CHANGE_MONEY) {
            money.setText(String.format("Деньги: %s", pCode.getInt("Money")));
            setResult(1);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
