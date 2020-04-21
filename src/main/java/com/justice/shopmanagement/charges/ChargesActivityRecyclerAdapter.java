package com.justice.shopmanagement.charges;

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

public class ChargesActivityRecyclerAdapter extends RecyclerView.Adapter<ChargesActivityRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<Goods> list;
    private ChargesActivity chargesActivity ;

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
        holder.priceTxtView.setText("$ "+list.get(position).getPrice());
        holder.removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeBtnTapped();

            }

            private void removeBtnTapped() {
                AllData.buyList.remove(list.get(position));
                notifyDataSetChanged();
                chargesActivity.calculateTotalAmount();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

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

    public ChargesActivityRecyclerAdapter(ChargesActivity chargesActivity,Context context) {
        this.chargesActivity=chargesActivity;
        this.context = context;
    }

    public void setList(List<Goods> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
