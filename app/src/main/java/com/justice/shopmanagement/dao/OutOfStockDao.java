package com.justice.shopmanagement.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;


import com.justice.shopmanagement.model.GoodsOutOfStock;

import java.util.List;

@Dao
public interface OutOfStockDao {

    @Insert
    void insert(GoodsOutOfStock goods);
    @Delete
    void delete(GoodsOutOfStock goods);

    @Query("DELETE FROM goods_out_of_stock")
    void deleteAllGoods();

    @Query("SELECT * FROM goods_out_of_stock ORDER BY price DESC")
    LiveData<List<GoodsOutOfStock>> getAllGoods();
}