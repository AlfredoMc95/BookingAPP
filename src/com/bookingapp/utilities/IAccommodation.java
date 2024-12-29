package com.bookingapp.utilities;


import java.time.LocalDate;

public interface IAccommodation {

    double calculateTotalPrice(int roomsQuantity, LocalDate checkIn);

}
