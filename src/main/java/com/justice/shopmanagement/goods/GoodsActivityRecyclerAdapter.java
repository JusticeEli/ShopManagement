package com.justice.shopmanagement.goods;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.justice.shopmanagement.EditGoodsActivity;
import com.justice.shopmanagement.R;
import com.justice.shopmanagement.alldata.AllData;

import java.util.List;

public class GoodsActivityRecyclerAdapter extends RecyclerView.Adapter<GoodsActivityRecyclerAdapter.ViewHolder> {
    private List<Goods> list;
    private Context context;

    public GoodsActivityRecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_goods, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.nameTxtView.setText(list.get(position).getName());
        holder.priceTxtView.setText("$ " + list.get(position).getPrice());
        holder.buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AllData.buyList.add(list.get(position))) {
                    Toast.makeText(context, "bought", Toast.LENGTH_SHORT).show();


                }
            }
        });
        holder.outOfStockTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean success = outOfStockClicked();

                if (success) {
                    Toast.makeText(context, "Added To Out Of Stock", Toast.LENGTH_SHORT).show();
                }
            }

            private boolean outOfStockClicked() {
                boolean success = false;

                if (!AllData.outOfStockList.contains(list.get(position))) {
                    success = AllData.outOfStockList.add(list.get(position));
                    AllData.writeAllDataToFiles();
                    return success;
                }
                return success;
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
                        Goods goods = AllData.goodsList.remove(position);
                        notifyDataSetChanged();
                        AllData.writeAllDataToFiles();

                        Toast.makeText(context, goods.getName() + " removed", Toast.LENGTH_SHORT).show();

                    }
                }).setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, EditGoodsActivity.class);
                        intent.putExtra("position", position);
                        context.startActivity(intent);

                    }
                });
                builder.create().show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

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

    public void setList(List<Goods> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
