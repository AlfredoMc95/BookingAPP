package com.bookingapp.models;

import com.bookingapp.utilities.IAccommodation;
import com.bookingapp.utilities.IActivity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.bookingapp.utilities.PrintMessage.printStrigMessage;

public class DayOfSun extends AccommodationBase implements IAccommodation, IActivity {
    private List<Activity> activities;
    private Boolean lunchIsInclude;

    public DayOfSun(String name, Integer rate, String city, double pricePerNight, List<Activity> activities, Boolean lunchIsInclude) {
        super(name, rate, city, pricePerNight);
        this.activities = activities;
        this.lunchIsInclude = lunchIsInclude;
    }

    public DayOfSun() {
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public boolean isLunchIsInclude() {
        return lunchIsInclude;
    }

    public void setLunchIsInclude(boolean lunchIsInclude) {
        this.lunchIsInclude = lunchIsInclude;
    }

    @Override
    public void showActivity() {
        for (Activity activity : activities) {
            printStrigMessage("- " + activity.getName() + ": " + activity.getDescription());
        }
    }

    @Override
    public double calculateTotalPrice(int roomsQuantity, LocalDate checkIn) {
        return getPricePerNight() * roomsQuantity;
    }
}

