package com.example.gonkey_choro.viewsapplication.InventoryClasses;

import android.content.Context;
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

class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.ViewHolder> {
    private List<InventoryItem> items;
    private LayoutInflater inflater;
    private ShC sCode;
    private ShC pCode;
    private TextView invMoney;
    private Context context;

    InventoryAdapter(Context context, List<InventoryItem> items, AppCompatActivity activity) {
        this.items = items;
        inflater = LayoutInflater.from(context);
        sCode = new ShC(context, SHOP);
        pCode = new ShC(context, PROFILE);
        invMoney = (TextView)activity.findViewById(R.id.inv_money);
        this.context = context;
    }

    @Override
    public InventoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.inventory_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final InventoryAdapter.ViewHolder holder, int position) {
        final InventoryItem item = items.get(position);
        holder.image.setImageResource(item.getImage());
        holder.info.setText(item.getInfo());
        holder.cost.setText(item.getCost());
        holder.count.setText(item.getCount());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sCode.getInt('s'+String.valueOf(item.getPos())+'.'+String.valueOf(item.getNum())+'v') > 0) {
                    sCode.setInt('s' + String.valueOf(item.getPos()) + '.' + String.valueOf(item.getNum()) + 'v',
                            sCode.getInt('s' + String.valueOf(item.getPos()) + '.' + String.valueOf(item.getNum()) + 'v') - 1);
                    holder.count.setText(String.format("Количество: %s", sCode.getInt('s' + String.valueOf(item.getPos())
                            + '.' + String.valueOf(item.getNum()) + 'v')));
                    pCode.setInt("Money", pCode.getInt("Money")+
                            sCode.getInt('s'+String.valueOf(item.getPos())+'.'+String.valueOf(item.getNum())+'c')/3);
                    invMoney.setText(String.format("Деньги: %s", pCode.getInt("Money")));
                    sCode.setBool("m_c", true);
                } else Toast.makeText(context, "У вас нет этих вещей", Toast.LENGTH_SHORT).show();
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
        final TextView cost;
        final TextView count;
        final Button button;
        ViewHolder(View view) {
            super(view);
            image = (ImageView)view.findViewById(R.id.inv_item_image);
            info = (TextView)view.findViewById(R.id.inv_item_info);
            cost = (TextView)view.findViewById(R.id.inv_item_cost);
            count = (TextView)view.findViewById(R.id.inv_item_count);
            button = (Button)view.findViewById(R.id.inv_item_button);
        }
    }
}
