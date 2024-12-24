package com.bookingapp.models;

import com.bookingapp.utilities.IAccommodation;
import com.bookingapp.utilities.IActivity;

import java.util.List;

public class DayOfSun implements IAccommodation, IActivity {
    private String name;
    private double price;
    private List<Activity> activities;
    private String city;
    private boolean lunchIsInclude;

    public DayOfSun(String name, double price, List<Activity> activities, String city, boolean lunchIsInclude) {
        this.name = name;
        this.price = price;
        this.activities = activities;
        this.city = city;
        this.lunchIsInclude = lunchIsInclude;
    }

    public DayOfSun() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public double totalPriceSum(int roomsQuantity, int checkIn, int checkOut) {
        return 0;
    }

    @Override
    public void showInfo() {
        System.out.println("nombre: "+ this.name);
        System.out.println("precio: "+ this.price);
        if(this.lunchIsInclude){
            System.out.println("Almuerzo incluido");
        }
        else{
            System.out.println("Almuerzo no incluido");
        }
        showActivity();
    }

    @Override
    public void showActivity() {
        System.out.println("Actividades disponibles ");
        for (Activity activity: activities){
            System.out.println("- "+ activity.getName() +":"+activity.getDescription());
        }
    }
}
