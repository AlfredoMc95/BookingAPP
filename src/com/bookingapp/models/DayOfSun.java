package com.bookingapp.models;

import com.bookingapp.utilities.IAccommodation;

import java.util.Date;
import java.util.List;

public class DayOfSun implements IAccommodation {
    private String name;
    private List<Activity> activities;

    public DayOfSun(String name, List<Activity> activities) {
        this.name = name;
        this.activities = activities;
    }

    public DayOfSun() {
    }

    @Override
    public List<Room> checkAvailability(Date checkIn, Date checkOut, int quantityOfRooms) {
        return List.of();
    }

    @Override
    public double calculatePrice(int quantityOfRooms, Date checkIn, Date checkOut) {
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
