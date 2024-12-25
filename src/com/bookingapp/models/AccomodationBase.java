package com.bookingapp.models;

import com.bookingapp.utilities.IAccommodation;
import java.util.ArrayList;
import java.util.List;

public class AccomodationBase implements IAccommodation {
    private String name;
    private int rate;
    private String city;
    private double pricePerNight;
    private List<BookingTicket> bookingTicket;

    public AccomodationBase(String name, int rate,String city, double pricePerNight) {
        this.name = name;
        this.rate = rate;
        this.city = city;
        this.pricePerNight = pricePerNight;
        this.bookingTicket = new ArrayList<>();
    }

    public AccomodationBase() {
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public List<BookingTicket> getBookingTicket() {
        return bookingTicket;
    }

    public void addBookingTicket(BookingTicket bookingTicket) {
        this.bookingTicket.add(bookingTicket);
    }

    public double totalPriceSum(int quantityOfRooms, int checkIn){
        double totalPrice = pricePerNight * quantityOfRooms;
        double discount = totalPriceDiscount(checkIn);
        totalPrice = totalPrice + discount;
        return totalPrice;
    }

    protected double totalPriceDiscount(int checkIn){
        if (checkIn >= 25) {
            return (pricePerNight * 0.15);
        } else if (checkIn >= 10&& checkIn<25) {
            return (pricePerNight * 0.10);
        } else if (checkIn >= 5&& checkIn<10) {
            return -(pricePerNight * 0.08);
        }

        return 0;
    }
}
