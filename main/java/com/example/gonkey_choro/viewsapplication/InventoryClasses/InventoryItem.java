package com.example.gonkey_choro.viewsapplication.InventoryClasses;

class InventoryItem {
    private int invImage;
    private String invInfo;
    private String invCost;
    private String invCount;
    private int number;
    private int position;

    InventoryItem(int invImage, String invInfo, String invCount, String invCost, int position, int number) {
        this.invImage = invImage;
        this.invInfo = invInfo;
        this.invCost = invCost;
        this.invCount = invCount;
        this.number = number;
        this.position = position;
    }

    String getInfo() {
        return invInfo;
    }

    int getImage() {
        return invImage;
    }

    String getCost() {
        return invCost;
    }

    String getCount() {
        return invCount;
    }

    int getNum() {
        return number;
    }

    int getPos() {
        return position;
    }
}
