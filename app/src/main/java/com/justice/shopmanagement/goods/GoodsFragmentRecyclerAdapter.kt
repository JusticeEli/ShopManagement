package com.justice.shopmanagement.goods

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.justice.shopmanagement.R
import com.justice.shopmanagement.model.Goods
import com.justice.shopmanagement.model.GoodsBuy
import com.justice.shopmanagement.model.GoodsOutOfStock
import com.justice.shopmanagement.viewmodel.GoodBuyViewModel
import com.justice.shopmanagement.viewmodel.GoodsOutOfStockViewModel

class GoodsFragmentRecyclerAdapter(val context: Context,val onEdit:(goods:Goods)->Unit) : ListAdapter<Goods,GoodsViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GoodsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_goods, parent, false)
        return GoodsViewHolder(view)
    }

    override fun onBindViewHolder(holder: GoodsViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.nameTxtView.text = getItem(position)!!.name
        holder.priceTxtView.text = "$ " + getItem(position)!!.price
/*        holder.buyBtn.setOnClickListener {
            val goodsViewModel: GoodBuyViewModel =
                ViewModelProviders.of(context).get<GoodBuyViewModel>(
                    GoodBuyViewModel::class.java
                )
            val goods = getItem(position)
            goodsViewModel.insert(GoodsBuy(goods!!.name, goods.image, goods.price.toString()))
            Toast.makeText(context, "Bought", Toast.LENGTH_SHORT).show()
        }*/
        holder.outOfStockTxtView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                outOfStockClicked()
                Toast.makeText(context, "Added To Out Of Stock", Toast.LENGTH_SHORT).show()
            }

            private fun outOfStockClicked() {
            /*    val goodsViewModel: GoodsOutOfStockViewModel =
                    ViewModelProviders.of(context).get<GoodsOutOfStockViewModel>(
                        GoodsOutOfStockViewModel::class.java
                    )
                val (name, image, price) = Goods(
                    getItem(position)!!.name,
                    getItem(position)!!.image,
                    getItem(position)!!.price
                )
                goodsViewModel.insert(GoodsOutOfStock(name, image, price.toString()))*/
            }
        })

        holder.goodsCardView.setOnClickListener {
            onEdit(getItem(position))
        }
/*        holder.goodsCardView.setOnLongClickListener(object : OnLongClickListener {
            override fun onLongClick(v: View): Boolean {
                deleteOrEdit()
                return true
            }

            private fun deleteOrEdit() {
            *//*    val builder = AlertDialog.Builder(context).setTitle("Confirm")
                    .setNegativeButton("Delete !!") { dialog, which ->
                        context.goodsViewModel.delete(getItem(position))
                        Toast.makeText(
                            context,
                            getItem(position)!!.name + " removed",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    .setPositiveButton("Edit") { dialog, which ->
                        val intent = Intent(context, EditGoodsActivity::class.java)
                        AllData.goods = getItem(position)
                        context.startActivity(intent)
                        notifyItemChanged(position)
                    }
                builder.create().show()*//*
            }
        })*/
    }

    fun getGoodAt(adapterPosition: Int): Goods? {
        return getItem(adapterPosition)
    }




    }

     class GoodsViewHolder(v: View) : RecyclerView.ViewHolder(v) {
         val nameTxtView: TextView
        val outOfStockTxtView: TextView
        val priceTxtView: TextView
        val buyBtn: Button
        val goodsCardView: CardView

        init {
            nameTxtView = v.findViewById(R.id.nameTxtView)
            outOfStockTxtView = v.findViewById(R.id.outOfStockTxtView)
            priceTxtView = v.findViewById(R.id.priceTxtView)
            buyBtn = v.findViewById(R.id.buyBtn)
            goodsCardView = v.findViewById(R.id.goodsCardView)
        }
    }


        private val DIFF_CALLBACK: DiffUtil.ItemCallback<Goods> =
            object : DiffUtil.ItemCallback<Goods>() {
                override fun areItemsTheSame(oldItem: Goods, newItem: Goods): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: Goods, newItem: Goods): Boolean {
                    return oldItem.name == newItem.name && oldItem.price.equals(newItem.price)
                }
            }



