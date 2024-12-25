package com.bookingapp.models;

public class BookingTicket {
    private User user;
    private Room room;

    public BookingTicket(User user, Room room) {
        this.user = user;
        this.room = room;
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
}
