package com.bookingapp.models;

public class Room {
    private String Usuario;
    private float price;
    private String description;
    private boolean isAvalible;

    public Room(String usuario, float price, String description, boolean isAvalible) {
        Usuario = usuario;
        this.price = price;
        this.description = description;
        this.isAvalible = isAvalible;
    }

    public Room() {
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvalible() {
        return isAvalible;
    }

    public void setAvalible(boolean avalible) {
        isAvalible = avalible;
    }
}
