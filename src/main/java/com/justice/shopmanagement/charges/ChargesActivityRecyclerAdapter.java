package com.justice.shopmanagement.charges;

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
import com.justice.shopmanagement.alldata.AllData;
import com.justice.shopmanagement.model.Goods;
import com.justice.shopmanagement.model.GoodsBuy;

import java.util.ArrayList;
import java.util.List;

public class ChargesActivityRecyclerAdapter extends RecyclerView.Adapter<ChargesActivityRecyclerAdapter.ViewHolder> implements Filterable {
    private ChargesActivity context;
    private List<GoodsBuy> list = new ArrayList<>();
    private ChargesActivity chargesActivity;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_charges, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.nameTxtView.setText(list.get(position).getName());
        holder.priceTxtView.setText("$ " + list.get(position).getPrice());
        holder.removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeBtnTapped();

            }

            private void removeBtnTapped() {
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
            List<GoodsBuy> resultList = new ArrayList<>();
            for (GoodsBuy goods : context.goodsViewModel.getAllGoods().getValue()) {
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
        private TextView nameTxtView, priceTxtView;
        private Button removeBtn;


        public ViewHolder(@NonNull View v) {
            super(v);
            nameTxtView = v.findViewById(R.id.nameTxtView);
            priceTxtView = v.findViewById(R.id.priceTxtView);
            removeBtn = v.findViewById(R.id.removeBtn);


        }
    }

    public ChargesActivityRecyclerAdapter(ChargesActivity chargesActivity, Context context) {
        this.chargesActivity = chargesActivity;
        this.context = (ChargesActivity) context;
    }

    public void setList(List<GoodsBuy> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
