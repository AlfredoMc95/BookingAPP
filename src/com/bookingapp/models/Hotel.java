package com.bookingapp.models;

import java.util.List;

public class Hotel extends AccomodationBase {
    private List<Room> rooms;

    public Hotel(String name, int rate, double pricePerNight, String city, List<Room> rooms) {
        super(name,rate,city,pricePerNight);
        this.rooms = rooms;
    }

    public Hotel() {
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
