package com.bookingapp.controllers;

import com.bookingapp.models.AccommodationBase;
import com.bookingapp.models.Apartment;
import com.bookingapp.models.DayOfSun;
import com.bookingapp.models.Hotel;
import com.bookingapp.utilities.BookingMediator;
import com.bookingapp.utilities.Mediator;

import java.time.LocalDate;
import java.util.List;

import static com.bookingapp.utilities.PrintMessage.*;
import static com.bookingapp.views.PrintApartmentDetails.printApartmentDetails;
import static com.bookingapp.views.PrintHotelDetails.printHotelDetails;
import static com.bookingapp.views.printDayOfSunDetails.printDayOfSunDetails;

public class PrintAccommodationResults {
    private static final Mediator mediator = BookingMediator.getInstance();

    public static void printResults(String city, String type, LocalDate checkIn, LocalDate checkOut, int adults, int children, int rooms) {
        List<AccommodationBase> results = mediator.findAccommodations(city, type, checkIn, checkOut, adults, children, rooms);

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
