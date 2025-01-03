package com.bookingapp.models;

import com.bookingapp.utilities.IAccommodation;

import java.awt.*;
import java.time.LocalDate;

public class AccommodationBase implements IAccommodation {
    private String name;
    private Integer rate;
    private String city;
    private Double pricePerNight;

    // Constructor para inicializar todos los atributos
    public AccommodationBase(String name, Integer rate, String city, Double pricePerNight) {
        this.name = name;
        this.rate = rate;
        this.city = city;
        this.pricePerNight = pricePerNight;
    }

    public AccommodationBase() {
    }

    // Métodos getter y setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    // calcula precio total
    public double calculateTotalPrice(int quantityOfRooms, LocalDate checkIn) {
        double totalPrice = this.getPricePerNight() * quantityOfRooms;
        return totalPrice;
    }




    //ejemplo grafico
    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 100, 30);
        g.drawString(name, x + 5, y + 20);
    }
}

