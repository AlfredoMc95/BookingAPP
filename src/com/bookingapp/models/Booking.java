package com.bookingapp.models;

import java.util.Date;

public class Booking {
    private User user;
    private Hotel hotel;
    private Room roomType;
    private Date checkIn;
    private Date checkout;
    private int adults;
    private int children;
    private int roomamount;
    private float totalPrice;
    private float discount;
    private float increases;

    public Booking(User user, Hotel hotel, Room roomType, Date checkIn, Date checkout, int adults, int children, int roomamount, float totalPrice, float discount, float increases) {
        this.user = user;
        this.hotel = hotel;
        this.roomType = roomType;
        this.checkIn = checkIn;
        this.checkout = checkout;
        this.adults = adults;
        this.children = children;
        this.roomamount = roomamount;
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

    public Room getRoomType() {
        return roomType;
    }

    public void setRoomType(Room roomType) {
        this.roomType = roomType;
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

    public int getRoomamount() {
        return roomamount;
    }

    public void setRoomamount(int roomamount) {
        this.roomamount = roomamount;
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
