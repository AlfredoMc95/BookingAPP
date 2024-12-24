package com.bookingapp.models;

import com.bookingapp.utilities.IAccommodation;

public class AccomodationBase implements IAccommodation {
    private String name;
    private int rate;
    private String city;
    private double pricePerNight;

    public AccomodationBase(String name, int rate,String city, double pricePerNight) {
        this.name = name;
        this.rate = rate;
        this.city = city;
        this.pricePerNight = pricePerNight;
    }

    public AccomodationBase() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    @Override
    public void showInfo(){
        System.out.println("nombre: " + this.name);
        System.out.println("calificacion: " + this.rate);
        System.out.println("Precio noche: " + this.pricePerNight);
        System.out.println("-------------------------------------");
    }

    public double totalPriceSum(int quantityOfRooms, int checkIn, int checkOut){
        double totalPrice = pricePerNight * quantityOfRooms * (checkIn-checkOut-1);
        double discount = totalPriceDiscount(checkIn , checkOut);
        totalPrice += discount;
        return totalPrice;
    }

    protected double totalPriceDiscount(int checkIn , int checkOut){
        if (checkIn > 5 && checkOut <= 31) {
            return (pricePerNight * 0.15);
        } else if (checkIn >= 10 && checkOut <= 15) {
            return (pricePerNight * 0.10);
        } else if (checkIn >= 5 && checkIn < 10) {
            return -(pricePerNight * 0.08);
        }

        return 0;
    }
}
