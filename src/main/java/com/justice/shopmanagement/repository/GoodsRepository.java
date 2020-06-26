package com.justice.shopmanagement.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.justice.shopmanagement.dao.GoodsDao;
import com.justice.shopmanagement.database.GoodsDatabase;
import com.justice.shopmanagement.model.Goods;
import com.justice.shopmanagement.model.GoodsOutOfStock;

import java.util.List;

public class GoodsRepository {
    private GoodsDao goodsDao;
    private LiveData<List<Goods>> allGoods;

    public GoodsRepository(Application application) {
        GoodsDatabase database = GoodsDatabase.getInstance(application);
        goodsDao = database.goodsDao();
        allGoods = goodsDao.getAllGoods();
    }

    public void insert(Goods goods) {
        new InsertNoteAsyncTask(goodsDao).execute(goods);
    }

    public void update(Goods goods) {
        new UpdateNoteAsyncTask(goodsDao).execute(goods);
    }

    public void delete(Goods goods) {
        new DeleteNoteAsyncTask(goodsDao).execute(goods);
    }

    public void deleteAllGoods() {
        new DeleteAllNotesAsyncTask(goodsDao).execute();
    }

    public LiveData<List<Goods>> getAllGoods() {
        return allGoods;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Goods, Void, Void> {
        private GoodsDao goodsDao1;

        private InsertNoteAsyncTask(GoodsDao noteDao) {
            this.goodsDao1 = noteDao;
        }

        @Override
        protected Void doInBackground(Goods... goods) {
            goodsDao1.insert(goods[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Goods, Void, Void> {
        private GoodsDao goodDao;

        private UpdateNoteAsyncTask(GoodsDao goodsDao) {
            this.goodDao = goodsDao;
        }

        @Override
        protected Void doInBackground(Goods... goods) {
            goodDao.update(goods[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<Goods, Void, Void> {
        private GoodsDao goodsDao;

        private DeleteNoteAsyncTask(GoodsDao goodsDao) {
            this.goodsDao = goodsDao;
        }

        @Override
        protected Void doInBackground(Goods... goods) {
            goodsDao.delete(goods[0]);
            return null;
        }
    }

    private static class DeleteAllNotesAsyncTask extends AsyncTask<Void, Void, Void> {
        private GoodsDao goodsDao;

        private DeleteAllNotesAsyncTask(GoodsDao goodsDao) {
            this.goodsDao = goodsDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            goodsDao.deleteAllGoods();
            return null;
        }
    }
}