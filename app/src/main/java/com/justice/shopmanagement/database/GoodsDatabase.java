package com.justice.shopmanagement.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


import com.justice.shopmanagement.dao.GoodsBuyDao;
import com.justice.shopmanagement.dao.GoodsDao;
import com.justice.shopmanagement.dao.OutOfStockDao;
import com.justice.shopmanagement.model.Goods;
import com.justice.shopmanagement.model.GoodsBuy;
import com.justice.shopmanagement.model.GoodsOutOfStock;

@Database(entities = {Goods.class, GoodsBuy.class, GoodsOutOfStock.class}, version = 2,exportSchema = false)
public abstract class GoodsDatabase extends RoomDatabase {

    private static GoodsDatabase instance;

    public abstract GoodsDao goodsDao();

    public abstract GoodsBuyDao goodsBuyDao();

    public abstract OutOfStockDao outOfStockDao();

    public static synchronized GoodsDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    GoodsDatabase.class, "goods_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private GoodsDao goodsDao;

        private PopulateDbAsyncTask(GoodsDatabase db) {
            goodsDao = db.goodsDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            goodsDao.insert(new Goods("soko ugali 2kg", "null", 135));
            goodsDao.insert(new Goods("ndovu ugali 2kg", "null", 125));
            goodsDao.insert(new Goods("Blueband 500g", "null", 180));
            goodsDao.insert(new Goods("sunlight 500g", "null", 130));
            goodsDao.insert(new Goods("sunlight powder 40g", "null", 10));
            goodsDao.insert(new Goods("sun light bar soap 175g", "null", 45));
            goodsDao.insert(new Goods("sunlight bar soap 50g", "null", 15));
            goodsDao.insert(new Goods("white wash bar soap 200g", "null", 25));


            return null;
        }
    }
}