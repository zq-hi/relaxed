package com.example.make_1230.util;

public class data {
    private String name;
    private String price;
    private String saletime;
    private String salenumber;
    public data(String name, String price, String saletime, String salenumber) {
        this.name = name;
        this.price = price;
        this.saletime = saletime;
        this.salenumber = salenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSaletime() {
        return saletime;
    }

    public void setSaletime(String saletime) {
        this.saletime = saletime;
    }

    public String getSalenumber() {
        return salenumber;
    }

    public void setSalenumber(String salenumber) {
        this.salenumber = salenumber;
    }


}
