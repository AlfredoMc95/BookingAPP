package com.bookingapp.models;

import com.bookingapp.utilities.IAccommodation;

import java.time.LocalDate;
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

    public double calculateTotalPrice(int quantityOfRooms, LocalDate checkIn){
        double totalPrice = this.pricePerNight * quantityOfRooms;
        double discount = totalPriceDiscount(checkIn);
        totalPrice = totalPrice + discount;
        return totalPrice;
    }

    public double totalPriceDiscount(LocalDate checkIn) {
        int checkInDay = checkIn.getDayOfMonth();

        double discount = calculateDiscount(checkInDay);

        return this.pricePerNight * discount;
    }

    private double calculateDiscount(int checkInDay) {
        if (isEndOfMonth(checkInDay, checkInDay)) {
            return 0.15;
        }
        if (isWithinRange(checkInDay, 10, 15)) {
            return 0.10;
        }
        if (isWithinRange(checkInDay, 5, 9)) {
            return -0.08;
        }
        return 0;
    }

    private boolean isEndOfMonth(int checkInDay, int lengthOfMonth) {
        return checkInDay > (lengthOfMonth - 5);
    }

    private boolean isWithinRange(int checkInDay, int start, int end) {
        return checkInDay >= start && checkInDay <= end;
    }

}
