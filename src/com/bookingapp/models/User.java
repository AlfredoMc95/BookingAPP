package com.bookingapp.models;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String nationality;
    private String phone;
    private String birthdate;

    // constructor
    public User( String firstName, String lastName, String email, String nationality, String phone, String birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.nationality = nationality;
        this.phone = phone;
        this.birthdate = birthdate;
    }

    // esto es para crear un usuario sin data
    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
