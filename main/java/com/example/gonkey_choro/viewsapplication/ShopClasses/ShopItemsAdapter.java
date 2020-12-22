package com.example.gonkey_choro.viewsapplication.ShopClasses;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.gonkey_choro.viewsapplication.R;
import com.example.gonkey_choro.viewsapplication.ShC;

import java.util.List;

import static com.example.gonkey_choro.viewsapplication.MainActivity.PROFILE;
import static com.example.gonkey_choro.viewsapplication.MainActivity.SHOP;

class ShopItemsAdapter extends RecyclerView.Adapter<ShopItemsAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<ShopItem> items;
    private Context context;
    private ShC sCode;
    private String prefix;
    private ShC pCode;
    private TextView money;

    ShopItemsAdapter(Context context, List<ShopItem> items, String prefix, AppCompatActivity activity) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.prefix = prefix;
        sCode = new ShC(context, SHOP);
        pCode = new ShC(context, PROFILE);
        money = (TextView)activity.findViewById(R.id.shop_items_money);
    }

    @Override
    public ShopItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.shop_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ShopItemsAdapter.ViewHolder holder, int position) {
        final ShopItem item = items.get(position);
        holder.image.setImageResource(item.getImage());
        holder.info.setText(item.getInfo());
        final int pos = holder.getAdapterPosition();
        holder.buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pCode.getInt("Money") >= sCode.getInt(prefix+String.valueOf(pos)+'c')) {
                    sCode.setInt(prefix+String.valueOf(pos)+'v', sCode.getInt(prefix+String.valueOf(pos)+'v')+1);
                    pCode.setInt("Money", pCode.getInt("Money")-sCode.getInt(prefix+String.valueOf(pos)+'c'));
                    item.setInfo(sCode.getString(prefix+String.valueOf(pos)+'i')+'\n'
                            +String.format("Стоимость: %s\nУ вас есть: %s", sCode.getInt(prefix+String.valueOf(pos)+'c'),
                            sCode.getInt(prefix+String.valueOf(pos)+'v')));
                    holder.info.setText(item.getInfo());
                    sCode.setBool("m_c", true);
                    money.setText(String.format("Деньги: %s", pCode.getInt("Money")));
                } else Toast.makeText(context, "Недостаточно денег", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView image;
        final TextView info;
        final Button buy;
        ViewHolder(View view) {
            super(view);
            image = (ImageView)view.findViewById(R.id.shop_item_image);
            info = (TextView)view.findViewById(R.id.shop_item_info);
            buy = (Button)view.findViewById(R.id.shop_item_button);
        }
    }
}
