package com.bookingapp;

import com.bookingapp.controllers.Booking;
import com.bookingapp.controllers.MainMenuDisplay;
import com.bookingapp.utilities.DataInitializer;

public class BookingApp {

    public static void main(String[] args) {
        Booking.accommodations = DataInitializer.initializeAccommodations();

        MainMenuDisplay mainMenuDisplay = new MainMenuDisplay();
        mainMenuDisplay.mainMenuDisplay();

    }
}
