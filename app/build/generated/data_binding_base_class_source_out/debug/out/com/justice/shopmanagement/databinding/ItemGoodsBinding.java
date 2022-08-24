// Generated by view binder compiler. Do not edit!
package com.justice.shopmanagement.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.justice.shopmanagement.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemGoodsBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final Button buyBtn;

  @NonNull
  public final CardView goodsCardView;

  @NonNull
  public final TextView nameTxtView;

  @NonNull
  public final TextView outOfStockTxtView;

  @NonNull
  public final TextView priceTxtView;

  private ItemGoodsBinding(@NonNull CardView rootView, @NonNull Button buyBtn,
      @NonNull CardView goodsCardView, @NonNull TextView nameTxtView,
      @NonNull TextView outOfStockTxtView, @NonNull TextView priceTxtView) {
    this.rootView = rootView;
    this.buyBtn = buyBtn;
    this.goodsCardView = goodsCardView;
    this.nameTxtView = nameTxtView;
    this.outOfStockTxtView = outOfStockTxtView;
    this.priceTxtView = priceTxtView;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemGoodsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemGoodsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_goods, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemGoodsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buyBtn;
      Button buyBtn = ViewBindings.findChildViewById(rootView, id);
      if (buyBtn == null) {
        break missingId;
      }

      CardView goodsCardView = (CardView) rootView;

      id = R.id.nameTxtView;
      TextView nameTxtView = ViewBindings.findChildViewById(rootView, id);
      if (nameTxtView == null) {
        break missingId;
      }

      id = R.id.outOfStockTxtView;
      TextView outOfStockTxtView = ViewBindings.findChildViewById(rootView, id);
      if (outOfStockTxtView == null) {
        break missingId;
      }

      id = R.id.priceTxtView;
      TextView priceTxtView = ViewBindings.findChildViewById(rootView, id);
      if (priceTxtView == null) {
        break missingId;
      }

      return new ItemGoodsBinding((CardView) rootView, buyBtn, goodsCardView, nameTxtView,
          outOfStockTxtView, priceTxtView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}