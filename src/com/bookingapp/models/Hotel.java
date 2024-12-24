package com.bookingapp.models;

import java.util.List;

public class Hotel {
    private String name;
    private int rate;
    private float pricePerNight;
    private List<Room> rooms;
    private List<Booking> booking;

    public Hotel(String name, int rate, float pricePerNight, List<Room> rooms, List<Booking> booking) {
        this.name = name;
        this.rate = rate;
        this.pricePerNight = pricePerNight;
        this.rooms = rooms;
        this.booking = booking;
    }

    public Hotel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public float getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(float pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }
}
