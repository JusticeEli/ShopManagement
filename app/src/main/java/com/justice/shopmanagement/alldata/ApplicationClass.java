package com.justice.shopmanagement.alldata;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class ApplicationClass extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AllData.initializeReadAndWriteFiles();
        AllData.readAllDataFromFiles();
        if (AllData.goodsList.isEmpty()) {
            AllData.putDummyData();

        }


    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        AllData.writeAllDataToFiles();
    }
}
