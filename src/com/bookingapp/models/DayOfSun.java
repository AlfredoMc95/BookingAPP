package com.bookingapp.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DayOfSun extends Accommodation {
    private List<Activity> activities;

    public DayOfSun(String name, float price, List<Activity> activities) {
        super(name, price);
        this.activities = new ArrayList<>();
    }

    public DayOfSun() {

    }

    @Override
    public List<Room> CheckAvailability(Date checkIn, Date checkOut, int quantityOfRooms) {
        return List.of();
    }

    @Override
    public double totalPrice(Date checkIn, Date checkOut, int quantityOfRooms) {
        return 0;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
