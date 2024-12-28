package com.bookingapp.models;

public class Apartment extends AccommodationBase {
    public Apartment(String name, int rate, String city, double pricePerNight) {
        super(name, rate,city, pricePerNight);
    }

    public Apartment() {
    }
}
