package com.justice.shopmanagement.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;

@Entity(tableName = "goods")
public class Goods {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String image;
    private String price;



    public Goods(String name, String image, String price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }





    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
