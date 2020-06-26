package com.justice.shopmanagement.out_of_stock;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.justice.shopmanagement.R;
import com.justice.shopmanagement.model.GoodsOutOfStock;

import java.util.ArrayList;
import java.util.List;

public class OutOfStockRecyclerAdapter extends RecyclerView.Adapter<OutOfStockRecyclerAdapter.ViewHolder> implements Filterable {
    private OutOfStockActivity context;
    private List<GoodsOutOfStock> list=new ArrayList<>();

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
              context.goodsViewModel.delete(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<GoodsOutOfStock> resultList = new ArrayList<>();
            for (GoodsOutOfStock goods : context.goodsViewModel.getAllGoods().getValue()) {
                if (goods.getName().toLowerCase().contains(constraint.toString().toLowerCase())) {
                    resultList.add(goods);
                }
            }
            FilterResults results = new FilterResults();
            if (constraint.toString().trim().isEmpty()) {
                results.values = context.goodsViewModel.getAllGoods().getValue();
            } else {
                results.values = resultList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            setList((List) results.values);
        }
    };


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTxtView;
        private Button addToStockBtn;
        public ViewHolder(@NonNull View v) {
            super(v);
            nameTxtView = v.findViewById(R.id.nameTxtView);
            addToStockBtn = v.findViewById(R.id.addToStockBtn);

        }
    }

    public void setList(List<GoodsOutOfStock> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public OutOfStockRecyclerAdapter(Context context) {
        this.context = (OutOfStockActivity) context;
    }
}
