package com.example.mobileprogproject;

import android.app.Application;

public class model extends Application {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    private String name;

    public model(String name, Integer image, Integer harga) {
        this.name = name;
        this.image = image;
        this.harga = harga;
    }

    private Integer image;

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    private Integer harga;
}
