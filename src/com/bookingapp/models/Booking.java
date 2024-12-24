package com.bookingapp.models;

import java.util.Date;

public class Booking {
    private User user;
    private Accommodation accommodation;
    private Room roomType;
    private Date checkIn;
    private Date checkout;
    private int adults;
    private int children;
    private int roomAmount;
    private float totalPrice;
    private float discount;
    private float increases;

    public Booking(User user, Accommodation accommodation, Room roomType, Date checkIn, Date checkout, int adults, int children, int roomAmount, float totalPrice, float discount, float increases) {
        this.user = user;
        this.accommodation = accommodation;
        this.roomType = roomType;
        this.checkIn = checkIn;
        this.checkout = checkout;
        this.adults = adults;
        this.children = children;
        this.roomAmount = roomAmount;
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

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
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

    public int getRoomAmount() {
        return roomAmount;
    }

    public void setRoomAmount(int roomAmount) {
        this.roomAmount = roomAmount;
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
