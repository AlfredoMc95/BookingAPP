package com.bookingapp.controllers;

import com.bookingapp.models.BookingTicket;
import com.bookingapp.models.Hotel;
import com.bookingapp.models.Room;
import com.bookingapp.models.User;
import com.bookingapp.views.ReservationData;
import static com.bookingapp.utilities.PrintMessage.printSeparator;
import static com.bookingapp.utilities.PrintMessage.printStrigMessage;


public class UpdateHotel {
    public static void updateHotel(BookingTicket ticketToUpdate, Hotel hotelWithBooking){
        if (ticketToUpdate == null || hotelWithBooking == null) {
            printStrigMessage("No se puede actualizar la reserva, datos inválidos.");
            printSeparator();
            return;
        }

        printStrigMessage("Eliminando reserva actual...");
        hotelWithBooking.getBookingTicket().remove(ticketToUpdate);

        Room room = ticketToUpdate.getRoom();
        if (room != null) {
            room.setAvailable(true);
        }

        printStrigMessage("Reserva eliminada con éxito. Por favor, cree una nueva reserva.");
        printSeparator();
        User user = ticketToUpdate.getUser();

        ReservationData.reservationData(user);
    }
}
