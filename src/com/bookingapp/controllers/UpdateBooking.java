package com.bookingapp.controllers;

import com.bookingapp.models.*;

import java.util.Scanner;

import static com.bookingapp.controllers.Booking.accommodations;
import static com.bookingapp.controllers.UpdateHotel.updateHotel;
import static com.bookingapp.controllers.UpdateRoom.updateRoom;
import static com.bookingapp.utilities.PrintMessage.*;
import static com.bookingapp.utilities.PrintMessage.printStrigMessage;
import static com.bookingapp.views.BookingDataView.bookingDataView;

public class UpdateBooking {
    public static void updateBooking(String email, String birthdate) {

        BookingTicket ticketToUpdate = findBookingTicket(email, birthdate);

        if (ticketToUpdate == null) {
            printNotFound();
            printSeparator();
            return;
        }

        Hotel hotelWithBooking = findHotelWithBooking(ticketToUpdate);

        bookingDataView(hotelWithBooking, ticketToUpdate);
        handleBookingUpdate(ticketToUpdate, hotelWithBooking);
    }

    private static BookingTicket findBookingTicket(String email, String birthdate) {
        for (AccommodationBase accommodation : accommodations) {
            if (accommodation instanceof Hotel hotel) {
                for (BookingTicket ticket : hotel.getBookingTicket()) {
                    if (ticket.getUser().getEmail().equalsIgnoreCase(email) &&
                            ticket.getUser().getBirthdate().equalsIgnoreCase(birthdate)) {
                        return ticket;
                    }
                }
            }
        }
        return null;
    }

    private static Hotel findHotelWithBooking(BookingTicket ticketToUpdate) {
        for (AccommodationBase accommodation : accommodations) {
            if (accommodation instanceof Hotel hotel && hotel.getBookingTicket().contains(ticketToUpdate)) {
                return hotel;
            }
        }
        return null;
    }

    private static void handleBookingUpdate(BookingTicket ticketToUpdate, Hotel hotelWithBooking) {
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("Room")) {
            updateRoom(ticketToUpdate, hotelWithBooking);
        } else if (response.equalsIgnoreCase("Hotel")) {
            updateHotel(ticketToUpdate, hotelWithBooking);
        } else {
            printStrigMessage("No se realizó ningún cambio en la reserva.");
        }
    }
}