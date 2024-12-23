package com.bookingapp.models;

import java.util.Date;

public class Booking {
    private User user;
    private Hotel hotel;
    private Date checkIn;
    private Date checkout;
    private int adults;
    private int children;
    private float totalPrice;
    private float discount;
    private float increases;

    public Booking(User user, Hotel hotel, Date checkIn, Date checkout, int adults, int children, float totalPrice, float discount, float increases) {
        this.user = user;
        this.hotel = hotel;
        this.checkIn = checkIn;
        this.checkout = checkout;
        this.adults = adults;
        this.children = children;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.increases = increases;
    }

    public Booking() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getIncreases() {
        return increases;
    }

    public void setIncreases(float increases) {
        this.increases = increases;
    }
}
