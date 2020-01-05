package com.example.make_1230.util;

public class data_four {
    private String id;
    private String name;
    private String supplier;
    private String price;
    private String number;
    public data_four(String id, String name, String supplier, String price, String number) {
        this.id = id;
        this.name = name;
        this.supplier = supplier;
        this.price = price;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
