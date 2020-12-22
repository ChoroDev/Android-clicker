package com.example.gonkey_choro.viewsapplication.InventoryClasses;

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

public class InventoryActivity extends AppCompatActivity{
    ShC pCode;
    ShC sCode;
    List<InventoryItem> items = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory_activity);

        sCode = new ShC(this, SHOP);
        pCode = new ShC(this, PROFILE);
        TextView invMoney = (TextView)findViewById(R.id.inv_money);
        invMoney.setText(String.format("Деньги: %s", pCode.getInt("Money")));

        setData();
        RecyclerView invItems = (RecyclerView)findViewById(R.id.inv_list);
        InventoryAdapter adapter = new InventoryAdapter(this, items, this);
        invItems.setAdapter(adapter);
    }

    private void setData() {
        sCode.setBool("m_c", false);
        for (int i = 0; i < sCode.getInt("s_all.count"); i++) {
            for (int j = 0; j < sCode.getInt('s'+String.valueOf(i)+".count"); j++) {
                if (sCode.getInt('s'+ String.valueOf(i)+'.'+String.valueOf(j)+'v') > 0)
                    items.add(new InventoryItem(sCode.getInt('s'+String.valueOf(i)+'.'+String.valueOf(j)+'p'),
                            sCode.getString('s'+String.valueOf(i)+'.'+String.valueOf(j)+'i'),
                            String.format("Количество: %s", sCode.getInt('s'+String.valueOf(i)+'.'+String.valueOf(j)+'v')),
                            String.format("Продажа: %s", (int)(sCode.getInt('s'+String.valueOf(i)+'.'+String.valueOf(j)+'c')/3)), i, j));
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (sCode.getBool("m_c"))
            setResult(1);
        finish();
    }
}
