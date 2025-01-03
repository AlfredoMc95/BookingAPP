package com.bookingapp;

import com.bookingapp.controllers.MainMenuDisplay;
import com.bookingapp.models.AccommodationBase;
import com.bookingapp.utilities.DataInitializer;

import java.util.List;

import static com.bookingapp.utilities.AccommodationFactory.listAllAccommodations;

public class BookingApp {
    public static List<AccommodationBase> accommodations;
    public static void main(String[] args) {
        accommodations = DataInitializer.initializeAccommodations();

        MainMenuDisplay mainMenuDisplay = new MainMenuDisplay();
        mainMenuDisplay.mainMenuDisplay();
        listAllAccommodations();
    }
}
