package com.justice.shopmanagement.out_of_stock;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.justice.shopmanagement.R;
import com.justice.shopmanagement.alldata.AllData;
import com.justice.shopmanagement.goods.Goods;

import java.util.List;

public class OutOfStockRecyclerAdapter extends RecyclerView.Adapter<OutOfStockRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<Goods> list;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_out_of_stock, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.nameTxtView.setText(list.get(position).getName());
        holder.addToStockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  AllData.readAllDataFromFiles();
                AllData.outOfStockList.remove(list.get(position));
                notifyDataSetChanged();
                AllData.writeAllDataToFiles();

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTxtView;
        private Button addToStockBtn;
        public ViewHolder(@NonNull View v) {
            super(v);
            nameTxtView = v.findViewById(R.id.nameTxtView);
            addToStockBtn = v.findViewById(R.id.addToStockBtn);

        }
    }

    public void setList(List<Goods> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public OutOfStockRecyclerAdapter(Context context) {
        this.context = context;
    }
}
