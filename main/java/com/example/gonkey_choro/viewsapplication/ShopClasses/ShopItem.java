package com.example.gonkey_choro.viewsapplication.ShopClasses;

public class ShopItem {
    private int image;
    private String info;

    public ShopItem(int image, String info) {
        this.image = image;
        this.info = info;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getImage() {
        return image;
    }

    public String getInfo() {
        return info;
    }
}
