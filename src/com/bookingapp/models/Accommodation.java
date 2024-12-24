package com.bookingapp.models;

import java.util.List;
import java.util.Date;

public abstract class Accommodation {
    private String name;
    private float price;

    protected Accommodation(String name, float price) {
        this.name = name;
        this.price = price;
    }

    protected Accommodation() {
    }

    public  abstract List<Room> CheckAvailability(Date checkIn, Date checkOut, int quantityOfRooms);

    public  abstract double totalPrice(Date checkIn, Date checkOut, int quantityOfRooms);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
