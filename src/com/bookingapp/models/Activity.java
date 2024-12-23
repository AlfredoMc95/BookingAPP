package com.bookingapp.models;

public class Activity {
    private String name;
    private Boolean includesLunch;
    private Boolean includesSnack;
    private float price;

    public Activity(String name, Boolean includesLunch, Boolean includesSnack, float price) {
        this.name = name;
        this.includesLunch = includesLunch;
        this.includesSnack = includesSnack;
        this.price = price;
    }

    public Activity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIncludesLunch() {
        return includesLunch;
    }

    public void setIncludesLunch(Boolean includesLunch) {
        this.includesLunch = includesLunch;
    }

    public Boolean getIncludesSnack() {
        return includesSnack;
    }

    public void setIncludesSnack(Boolean includesSnack) {
        this.includesSnack = includesSnack;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
