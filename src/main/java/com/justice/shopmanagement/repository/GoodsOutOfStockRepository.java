package com.justice.shopmanagement.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.justice.shopmanagement.dao.GoodsBuyDao;
import com.justice.shopmanagement.dao.GoodsDao;
import com.justice.shopmanagement.dao.OutOfStockDao;
import com.justice.shopmanagement.database.GoodsDatabase;
import com.justice.shopmanagement.model.Goods;
import com.justice.shopmanagement.model.GoodsOutOfStock;

import java.util.List;

public class GoodsOutOfStockRepository {
    private OutOfStockDao goodsDao;
    private LiveData<List<GoodsOutOfStock>> allGoods;

    public GoodsOutOfStockRepository(Application application) {
        GoodsDatabase database = GoodsDatabase.getInstance(application);
        goodsDao = database.outOfStockDao();
        allGoods = goodsDao.getAllGoods();
    }

    public void insert(GoodsOutOfStock goods) {
        new InsertNoteAsyncTask(goodsDao).execute(goods);
    }


    public void delete(GoodsOutOfStock goods) {
        new DeleteNoteAsyncTask(goodsDao).execute(goods);
    }

    public void deleteAllGoods() {
        new DeleteAllNotesAsyncTask(goodsDao).execute();
    }

    public LiveData<List<GoodsOutOfStock>> getAllGoods() {
        return allGoods;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<GoodsOutOfStock, Void, Void> {
        private OutOfStockDao goodsDao1;

        private InsertNoteAsyncTask(OutOfStockDao noteDao) {
            this.goodsDao1 = noteDao;
        }

        @Override
        protected Void doInBackground(GoodsOutOfStock... goods) {
            goodsDao1.insert(goods[0]);
            return null;
        }
    }


    private static class DeleteNoteAsyncTask extends AsyncTask<GoodsOutOfStock, Void, Void> {
        private OutOfStockDao goodsDao;

        private DeleteNoteAsyncTask(OutOfStockDao goodsDao) {
            this.goodsDao = goodsDao;
        }

        @Override
        protected Void doInBackground(GoodsOutOfStock... goods) {
            goodsDao.delete(goods[0]);
            return null;
        }
    }

    private static class DeleteAllNotesAsyncTask extends AsyncTask<Void, Void, Void> {
        private OutOfStockDao goodsDao;

        private DeleteAllNotesAsyncTask(OutOfStockDao goodsDao) {
            this.goodsDao = goodsDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            goodsDao.deleteAllGoods();
            return null;
        }
    }
}