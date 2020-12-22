package com.example.gonkey_choro.viewsapplication.ShopClasses;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.gonkey_choro.viewsapplication.R;
import com.example.gonkey_choro.viewsapplication.ShC;
import java.util.ArrayList;
import java.util.List;

import static com.example.gonkey_choro.viewsapplication.MainActivity.PROFILE;
import static com.example.gonkey_choro.viewsapplication.MainActivity.SHOP;

public class ShopItemsActivity extends AppCompatActivity {
    List<ShopItem> items = new ArrayList<>();
    ShC sCode;
    ShC pCode;
    Bundle extra;
    Context context;
    TextView money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_items_activity);
        sCode = new ShC(this, SHOP);
        pCode = new ShC(this, PROFILE);
        extra = getIntent().getExtras();
        context = this;
        money = (TextView)findViewById(R.id.shop_items_money);
        money.setText(String.format("Деньги: %s", pCode.getInt("Money")));

        setData(String.valueOf(extra.getInt("section")));
        RecyclerView recycler = (RecyclerView) findViewById(R.id.shop_items);
        ShopItemsAdapter adapter = new ShopItemsAdapter(this, items, 's'+String.valueOf(extra.getInt("section"))+'.', this);
        recycler.setAdapter(adapter);
    }

    private void setData(String section) {
        sCode.setBool("m_c", false);
        String prefix = 's'+section+'.';
        for (int i = 0; i < sCode.getInt(prefix+"count"); i++)
            items.add(new ShopItem(R.drawable.avatarka, sCode.getString(prefix+String.valueOf(i)+'i')+'\n'
                    +String.format("Стоимость: %s\nУ вас есть: %s", sCode.getInt(prefix+String.valueOf(i)+'c'),
                    sCode.getInt(prefix+String.valueOf(i)+'v'))));
    }

    @Override
    public void onBackPressed(){
        if (sCode.getBool("m_c"))
            setResult(1);
        finish();
    }
}
