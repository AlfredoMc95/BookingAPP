package com.bookingapp.controllers;

import com.bookingapp.models.BookingTicket;
import com.bookingapp.models.Hotel;
import com.bookingapp.models.Room;
import com.bookingapp.models.User;

import java.time.LocalDate;
import java.util.List;

import static com.bookingapp.controllers.Booking.findAccommodationsByName;
import static com.bookingapp.utilities.PrintMessage.*;
import static com.bookingapp.views.PrintConfirmReservation.printConfirmReservation;

public class MakeReservation {
    public static void makeReservation(String hotelName, LocalDate checkIn, LocalDate checkOut, int adults, int children, int rooms, User userInfo){
        List<Object> results = findAccommodationsByName(hotelName, rooms);

        if (results.isEmpty()) {
            printNotFound();
            return;
        }

        for (Object result : results) {
            if (result instanceof Hotel hotel) {
                processHotelReservation(hotel, checkIn, rooms, userInfo);
            }
        }
    }

    private static void processHotelReservation(Hotel hotel, LocalDate checkIn, int rooms, User userInfo) {
        double totalPrice = hotel.calculateTotalPrice(rooms, checkIn);
        Room cheapestRoom = hotel.findCheapestRoom();

        if (cheapestRoom != null) {
            confirmReservation(hotel, userInfo, cheapestRoom, totalPrice);
        } else {
            printStrigMessage("No hay habitaciones disponibles en el hotel: " + hotel.getName());
            printSeparator();
        }
    }

    private static void confirmReservation(Hotel hotel, User userInfo, Room cheapestRoom, double totalPrice) {
        cheapestRoom.setAvailable(false);
        printConfirmReservation(hotel, userInfo, cheapestRoom, totalPrice);
        BookingTicket bookingTicket = new BookingTicket(userInfo, cheapestRoom, totalPrice);
        hotel.addBookingTicket(bookingTicket);
    }
}
