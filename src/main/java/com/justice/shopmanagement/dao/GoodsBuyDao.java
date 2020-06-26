package com.justice.shopmanagement.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.justice.shopmanagement.model.Goods;
import com.justice.shopmanagement.model.GoodsBuy;

import java.util.List;

@Dao
public interface GoodsBuyDao {

    @Insert
    void insert(GoodsBuy goods);

    @Delete
    void delete(GoodsBuy goods);

    @Query("DELETE FROM goods_buy")
    void deleteAllGoods();

    @Query("SELECT * FROM goods_buy ORDER BY price DESC")
    LiveData<List<GoodsBuy>> getAllGoods();
}