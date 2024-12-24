package com.bookingapp.utilities;


public interface IAccommodation {

    double totalPriceSum(int roomsQuantity, int checkIn, int checkOut);
    void showInfo();
}
