package com.justice.shopmanagement.goods;

import java.io.Serializable;
import java.util.Objects;

public class Goods implements Serializable,Comparable<Goods>{
    private String name;
    private String image;
    private String price;

    public Goods(String name, String image, String price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public Goods() {

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


    @Override
    public int compareTo(Goods goods) {
        return name.compareTo(goods.name);
    }
}
