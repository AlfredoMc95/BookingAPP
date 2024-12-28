package com.bookingapp.controllers;

import com.bookingapp.models.AccommodationBase;
import com.bookingapp.models.Apartment;
import com.bookingapp.models.DayOfSun;
import com.bookingapp.models.Hotel;

import java.util.List;

import static com.bookingapp.controllers.Booking.findAccommodations;
import static com.bookingapp.utilities.PrintMessage.*;
import static com.bookingapp.views.PrintApartmentDetails.printApartmentDetails;
import static com.bookingapp.views.PrintHotelDetails.printHotelDetails;
import static com.bookingapp.views.printDayOfSunDetails.printDayOfSunDetails;

public class PrintAccommodationResults {

    public static void printResults(String city, String type, int checkIn, int checkOut, int adults, int children, int rooms) {
        List<AccommodationBase> results = findAccommodations(city, type, checkIn, checkOut, adults, children, rooms);

        if (results.isEmpty()) {
            printNotFound();
            return;
        }

        for (Object result : results) {
            if (result instanceof Hotel hotel) {
                printHotelDetails(hotel, rooms, checkIn);
            } else if (result instanceof DayOfSun dayOfSun) {
                printDayOfSunDetails(dayOfSun);
            } else if (result instanceof Apartment apartment) {
                printApartmentDetails(apartment, rooms, checkIn);
            }
        }
    }
}
