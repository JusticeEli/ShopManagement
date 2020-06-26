package com.justice.shopmanagement.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.justice.shopmanagement.model.Goods;

import java.util.List;

@Dao
public interface GoodsDao {

    @Insert
    void insert(Goods goods);

    @Update
    void update(Goods goods);

    @Delete
    void delete(Goods goods);

    @Query("DELETE FROM goods")
    void deleteAllGoods();

    @Query("SELECT * FROM goods ORDER BY price DESC")
    LiveData<List<Goods>> getAllGoods();
}