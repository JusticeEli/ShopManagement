package com.justice.shopmanagement.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.justice.shopmanagement.model.Goods;
import com.justice.shopmanagement.repository.GoodsRepository;

import java.util.List;

public class GoodsViewModel extends AndroidViewModel {
    private GoodsRepository repository;
    private LiveData<List<Goods>> allGoods;

    public GoodsViewModel(@NonNull Application application) {
        super(application);
        repository = new GoodsRepository(application);
        allGoods = repository.getAllGoods();
    }

    public void insert(Goods goods) {
        repository.insert(goods);
    }

    public void update(Goods goods) {
        repository.update(goods);
    }

    public void delete(Goods goods) {
        repository.delete(goods);
    }

    public void deleteAllGoods() {
        repository.deleteAllGoods();
    }

    public LiveData<List<Goods>> getAllGoods() {
        return allGoods;
    }
}