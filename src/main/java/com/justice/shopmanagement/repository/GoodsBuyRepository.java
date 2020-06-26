package com.justice.shopmanagement.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.justice.shopmanagement.dao.GoodsBuyDao;
import com.justice.shopmanagement.dao.GoodsDao;
import com.justice.shopmanagement.database.GoodsDatabase;
import com.justice.shopmanagement.model.Goods;
import com.justice.shopmanagement.model.GoodsBuy;

import java.util.List;

public class GoodsBuyRepository {
    private GoodsBuyDao goodsDao;
    private LiveData<List<GoodsBuy>> allGoods;

    public GoodsBuyRepository(Application application) {
        GoodsDatabase database = GoodsDatabase.getInstance(application);
        goodsDao = database.goodsBuyDao();
        allGoods = goodsDao.getAllGoods();
    }

    public void insert(GoodsBuy goods) {
        new InsertNoteAsyncTask(goodsDao).execute(goods);
    }


    public void delete(GoodsBuy goods) {
        new DeleteNoteAsyncTask(goodsDao).execute(goods);
    }

    public void deleteAllGoods() {
        new DeleteAllNotesAsyncTask(goodsDao).execute();
    }

    public LiveData<List<GoodsBuy>> getAllGoods() {
        return allGoods;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<GoodsBuy, Void, Void> {
        private GoodsBuyDao goodsDao1;

        private InsertNoteAsyncTask(GoodsBuyDao noteDao) {
            this.goodsDao1 = noteDao;
        }

        @Override
        protected Void doInBackground(GoodsBuy... goods) {
            goodsDao1.insert(goods[0]);
            return null;
        }
    }


    private static class DeleteNoteAsyncTask extends AsyncTask<GoodsBuy, Void, Void> {
        private GoodsBuyDao goodsDao;

        private DeleteNoteAsyncTask(GoodsBuyDao goodsDao) {
            this.goodsDao = goodsDao;
        }

        @Override
        protected Void doInBackground(GoodsBuy... goods) {
            goodsDao.delete(goods[0]);
            return null;
        }
    }

    private static class DeleteAllNotesAsyncTask extends AsyncTask<Void, Void, Void> {
        private GoodsBuyDao goodsDao;

        private DeleteAllNotesAsyncTask(GoodsBuyDao goodsDao) {
            this.goodsDao = goodsDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            goodsDao.deleteAllGoods();
            return null;
        }
    }
}