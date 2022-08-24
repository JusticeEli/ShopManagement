package com.justice.shopmanagement.viewmodel;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.justice.shopmanagement.model.GoodsBuy;
import com.justice.shopmanagement.repository.GoodsBuyRepository;

import java.util.List;

 public  class GoodBuyViewModel extends AndroidViewModel {
    private GoodsBuyRepository repository;
    private LiveData<List<GoodsBuy>> allGoods;

    public GoodBuyViewModel(@NonNull Application application) {
        super(application);
        repository = new GoodsBuyRepository(application);
        allGoods = repository.getAllGoods();
    }

    public void insert(GoodsBuy goods) {
        repository.insert(goods);
    }

    public void delete(GoodsBuy goods) {
        repository.delete(goods);
    }

    public void deleteAllGoods() {
        repository.deleteAllGoods();
    }

    public LiveData<List<GoodsBuy>> getAllGoods() {
        return allGoods;
    }
}