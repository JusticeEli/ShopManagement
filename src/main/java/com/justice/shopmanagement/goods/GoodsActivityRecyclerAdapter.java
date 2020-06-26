package com.justice.shopmanagement.goods;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.justice.shopmanagement.EditGoodsActivity;
import com.justice.shopmanagement.R;
import com.justice.shopmanagement.alldata.AllData;
import com.justice.shopmanagement.model.Goods;
import com.justice.shopmanagement.model.GoodsBuy;
import com.justice.shopmanagement.model.GoodsOutOfStock;
import com.justice.shopmanagement.viewmodel.GoodBuyViewModel;
import com.justice.shopmanagement.viewmodel.GoodsOutOfStockViewModel;
import com.justice.shopmanagement.viewmodel.GoodsViewModel;

import java.util.ArrayList;
import java.util.List;

public class GoodsActivityRecyclerAdapter extends ListAdapter<Goods, GoodsActivityRecyclerAdapter.ViewHolder> implements Filterable {
    private GoodsActivity context;

    public GoodsActivityRecyclerAdapter(Context context) {
        super(DIFF_CALLBACK);

        this.context = (GoodsActivity) context;
    }


    private static final DiffUtil.ItemCallback<Goods> DIFF_CALLBACK = new DiffUtil.ItemCallback<Goods>() {
        @Override
        public boolean areItemsTheSame(Goods oldItem, Goods newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(Goods oldItem, Goods newItem) {
            return oldItem.getName().equals(newItem.getName()) && oldItem.getPrice().equals(newItem.getPrice());
        }
    };


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_goods, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.nameTxtView.setText(getItem(position).getName());
        holder.priceTxtView.setText("$ " + getItem(position).getPrice());
        holder.buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoodBuyViewModel goodsViewModel = ViewModelProviders.of(context).get(GoodBuyViewModel.class);
                Goods goods = getItem(position);
                goodsViewModel.insert(new GoodsBuy(goods.getName(), goods.getImage(), goods.getPrice()));
                Toast.makeText(context, "Bought", Toast.LENGTH_SHORT).show();

            }
        });
        holder.outOfStockTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outOfStockClicked();
                Toast.makeText(context, "Added To Out Of Stock", Toast.LENGTH_SHORT).show();

            }

            private void outOfStockClicked() {
                GoodsOutOfStockViewModel goodsViewModel = ViewModelProviders.of(context).get(GoodsOutOfStockViewModel.class);
                Goods goods = new Goods(getItem(position).getName(), getItem(position).getImage(), getItem(position).getPrice());
                goodsViewModel.insert(new GoodsOutOfStock(goods.getName(), goods.getImage(), goods.getPrice()));

            }
        });

        holder.goodsCardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                deleteOrEdit();

                return true;
            }

            private void deleteOrEdit() {
                AlertDialog.Builder builder = new AlertDialog.Builder(context).setTitle("Confirm").setNegativeButton("Delete !!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        context.goodsViewModel.delete(getItem(position));
                        Toast.makeText(context, getItem(position).getName() + " removed", Toast.LENGTH_SHORT).show();

                    }
                }).setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, EditGoodsActivity.class);
                        AllData.goods = getItem(position);
                        context.startActivity(intent);
                        notifyItemChanged(position);

                    }
                });
                builder.create().show();
            }
        });

    }


    public Goods getNoteAt(int adapterPosition) {
        return getItem(adapterPosition);
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Goods> resultList = new ArrayList<>();
            for (Goods goods : context.goodsViewModel.getAllGoods().getValue()) {
                if (goods.getName().toLowerCase().contains(constraint.toString().toLowerCase())) {
                    resultList.add(goods);
                }
            }
            FilterResults results = new FilterResults();
            if (constraint.toString().trim().isEmpty()){
                results.values=context.goodsViewModel.getAllGoods().getValue();
            }else {
                results.values = resultList;
            }
             return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            submitList((List) results.values);
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTxtView, outOfStockTxtView, priceTxtView;
        private Button buyBtn;
        private CardView goodsCardView;

        public ViewHolder(@NonNull View v) {
            super(v);

            nameTxtView = v.findViewById(R.id.nameTxtView);
            outOfStockTxtView = v.findViewById(R.id.outOfStockTxtView);
            priceTxtView = v.findViewById(R.id.priceTxtView);
            buyBtn = v.findViewById(R.id.buyBtn);
            goodsCardView = v.findViewById(R.id.goodsCardView);
        }
    }


}
