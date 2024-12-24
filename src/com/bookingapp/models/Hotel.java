package com.bookingapp.models;

import java.util.Date;
import java.util.List;

public class Hotel extends Accommodation{
    private int rate;
    private List<Room> rooms;
    private List<Booking> booking;

    public Hotel(String name, int rate, float price, List<Room> rooms, List<Booking> booking) {
        super(name,price);
        this.rate = rate;
        this.rooms = rooms;
        this.booking = booking;
    }

    public Hotel() {
    }

    //verificar cuartoos validos
    @Override
    public List<Room> CheckAvailability(Date checkIn, Date checkOut, int quantityOfRooms) {
        return List.of();
    }

    //verificar precio
    @Override
    public double totalPrice(Date checkIn, Date checkOut, int quantityOfRooms) {
        return 0;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
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
