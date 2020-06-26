package com.justice.shopmanagement.viewmodel;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.justice.shopmanagement.model.Goods;
import com.justice.shopmanagement.model.GoodsOutOfStock;
import com.justice.shopmanagement.repository.GoodsOutOfStockRepository;
import com.justice.shopmanagement.repository.GoodsRepository;

import java.util.List;

public  class GoodsOutOfStockViewModel extends AndroidViewModel {
    private GoodsOutOfStockRepository repository;
    private LiveData<List<GoodsOutOfStock>> allGoods;

    public GoodsOutOfStockViewModel(@NonNull Application application) {
        super(application);
        repository = new GoodsOutOfStockRepository(application);
        allGoods = repository.getAllGoods();
    }

    public void insert(GoodsOutOfStock goods) {
        repository.insert(goods);
    }

    public void delete(GoodsOutOfStock goods) {
        repository.delete(goods);
    }

    public void deleteAllGoods() {
        repository.deleteAllGoods();
    }

    public LiveData<List<GoodsOutOfStock>> getAllGoods() {
        return allGoods;
    }
}