package com.junhwa.doitmission14;

public class Item {
    String name, detail;
    int price;

    public Item(String name, int price, String detail) {
        this.name = name;
        this.detail = detail;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public int getPrice() {
        return price;
    }
}
