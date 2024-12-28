package com.bookingapp.models;

import com.bookingapp.utilities.IAccommodation;
import java.util.ArrayList;
import java.util.List;

public class AccommodationBase implements IAccommodation {
    private String name;
    private Integer rate;
    private String city;
    private Double pricePerNight;
    private List<BookingTicket> bookingTicket;

    public AccommodationBase(String name, Integer rate, String city, double pricePerNight) {
        this.name = name;
        this.rate = rate;
        this.city = city;
        this.pricePerNight = pricePerNight;
        this.bookingTicket = new ArrayList<>();
    }

    public AccommodationBase() {
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

    public double calculateTotalPrice(int quantityOfRooms, int checkIn){
        double totalPrice = this.pricePerNight * quantityOfRooms;
        double discount = totalPriceDiscount(checkIn);
        totalPrice = totalPrice + discount;
        return totalPrice;
    }

    /*
    public double totalPriceDiscount(int checkIn) {
        double discount = 0;
        if (checkIn >= 25) discount = 0.15;
        else if (checkIn >= 10) discount = 0.10;
        else if (checkIn >= 5) discount = -0.08;

        return this.pricePerNight * discount;
    }
    */

    public double totalPriceDiscount(int checkIn) {
        double discount;
        switch (checkIn) {
            case 25, 26, 27, 28, 29, 30 -> discount = 0.15;
            case 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 -> discount = 0.10;
            case 5, 6, 7, 8, 9 -> discount = -0.08;
            default -> discount = 0;
        }
        return this.pricePerNight * discount;
    }

}
