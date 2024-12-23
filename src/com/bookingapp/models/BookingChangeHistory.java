package com.bookingapp.models;

import java.util.Date;

public class BookingChangeHistory {
    private Booking booking;
    private String newData;
    private String oldData;

    public BookingChangeHistory(Booking booking, String newData, String oldData) {
        this.booking = booking;
        this.newData = newData;
        this.oldData = oldData;
    }

    public BookingChangeHistory() {
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getNewData() {
        return newData;
    }

    public void setNewData(String newData) {
        this.newData = newData;
    }

    public String getOldData() {
        return oldData;
    }

    public void setOldData(String oldData) {
        this.oldData = oldData;
    }
}
