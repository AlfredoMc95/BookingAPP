package com.bookingapp.utilities;

import com.bookingapp.models.AccommodationBase;
import com.bookingapp.models.BookingTicket;
import com.bookingapp.models.Hotel;

import java.time.LocalDate;
import java.util.List;

public interface Mediator {
        List<AccommodationBase> findAccommodations(String city, String type, LocalDate checkIn, LocalDate checkOut, int adults, int children, int rooms);

        void showRooms(String hotelName,LocalDate checkIn, LocalDate checkOut, int adults, int children, int rooms);

        BookingTicket findBookingTicket(String email, String birthdate);

        Hotel findHotelWithBooking(BookingTicket ticketToUpdate);

        void updateBooking(String email, String birthdate);
}
