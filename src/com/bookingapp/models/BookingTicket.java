package com.bookingapp.models;

public class BookingTicket {
    private User user;
    private Room room;
    private double totalPrice;

    public BookingTicket(User user, Room room, double totalPrice) {
        this.user = user;
        this.room = room;
        this.totalPrice = totalPrice;
    }

    public BookingTicket() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
