package com.bookingapp.models;

public class Estate extends AccomodationBase {
    public Estate(String name, int rate,String city, double pricePerNight) {
        super(name, rate,city, pricePerNight);
    }

    public Estate() {
    }
}