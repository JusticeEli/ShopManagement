package com.justice.shopmanagement.alldata;

import android.os.Environment;

import com.justice.shopmanagement.model.Goods;
import com.justice.shopmanagement.model.GoodsBuy;
import com.justice.shopmanagement.model.GoodsOutOfStock;
import com.justice.shopmanagement.user.UserLoginData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class AllData {

    public static String path;
    public static Goods goods = null;
    public static List<UserLoginData> userLoginDataList = new ArrayList<>();
    public static List<Goods> goodsList = new ArrayList<>();
    public static List<GoodsOutOfStock> outOfStockList = new ArrayList<>();
    public static List<GoodsBuy> buyList = new ArrayList<>();

    public static void putDummyData() {
        userLoginDataList.add(new UserLoginData("e", "e"));
        userLoginDataList.add(new UserLoginData("j", "j"));

        goodsList.add(new Goods("soko ugali 2kg", "null", 135));
        goodsList.add(new Goods("ndovu ugali 2kg", "null", 125));
        goodsList.add(new Goods("Blueband 500g", "null", 180));
        goodsList.add(new Goods("sunlight 500g", "null", 130));
        goodsList.add(new Goods("sunlight powder 40g", "null", 10));
        goodsList.add(new Goods("sun light bar soap 175g", "null", 45));
        goodsList.add(new Goods("sunlight bar soap 50g", "null", 15));
        goodsList.add(new Goods("white wash bar soap 200g", "null", 25));


    }

    public static void initializeReadAndWriteFiles() {
        path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/shopdata";
        File dir = new File(path);
        dir.mkdirs();

    }

    public static void readAllDataFromFiles() {
        AllData allData = new AllData();
        allData.readUserLoginDataList();
        allData.readGoodsList();
        allData.readOutOfStockList();
        //  allData.readBuyList();


    }

    private void readBuyList() {
        AllData allData = new AllData();
        try {
            FileInputStream fileInputStream = new FileInputStream(path + "/buy.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            AllData.buyList = (ArrayList<GoodsBuy>) objectInputStream.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readOutOfStockList() {
        AllData allData = new AllData();
        try {
            FileInputStream fileInputStream = new FileInputStream(path + "/out_of_stock.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            AllData.outOfStockList = (ArrayList<GoodsOutOfStock>) objectInputStream.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readGoodsList() {
        AllData allData = new AllData();
        try {
            FileInputStream fileInputStream = new FileInputStream(path + "/goods.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            AllData.goodsList = (ArrayList<Goods>) objectInputStream.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readUserLoginDataList() {
        AllData allData = new AllData();
        try {
            FileInputStream fileInputStream = new FileInputStream(path + "/user_login_data.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            AllData.userLoginDataList = (ArrayList<UserLoginData>) objectInputStream.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void writeAllDataToFiles() {
        AllData allData = new AllData();
        allData.writeUserLoginDataList();
        allData.writeGoodsList();
        allData.writeOutOfStockList();
        //  allData.writeBuyList();


    }

    private void writeBuyList() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path + "/buy.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(AllData.buyList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeOutOfStockList() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path + "/out_of_stock.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(AllData.outOfStockList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeGoodsList() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path + "/goods.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(AllData.goodsList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeUserLoginDataList() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path + "/user_login_data.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(AllData.userLoginDataList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
