package com.bookingapp.models;

public class Room {
    private String type;
    private float price;
    private String description;
    private boolean isAvailable;

    public Room(String type, float price, String description, boolean isAvailable) {
        this.type = type;
        this.price = price;
        this.description = description;
        this.isAvailable = isAvailable;
    }

    public Room() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
