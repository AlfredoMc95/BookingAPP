package com.bookingapp;

import com.bookingapp.controllers.Booking;
import com.bookingapp.views.*;
import com.bookingapp.utilities.DataInitializer;

public class BookingApp {

    public static void main(String[] args) {
        // Inicializar datos ... alojamiemtos y dia de sol
        Booking.accommodations = DataInitializer.initializeAccommodations();
        Booking.dayOfSunOptions = DataInitializer.initializeDayOfSun();

        MainMenuDisplay mainMenuDisplay = new MainMenuDisplay();
        mainMenuDisplay.mainMenuDisplay();

    }
}
