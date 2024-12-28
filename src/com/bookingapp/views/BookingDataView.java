package com.bookingapp.views;

import com.bookingapp.models.BookingTicket;
import com.bookingapp.models.Hotel;
import com.bookingapp.models.Room;
import com.bookingapp.models.User;

import static com.bookingapp.utilities.PrintMessage.printSeparator;
import static com.bookingapp.utilities.PrintMessage.printStrigMessage;

public class BookingDataView {
    public static void bookingDataView(Hotel hotel, BookingTicket ticket) {
        User user = ticket.getUser();
        Room room = ticket.getRoom();
        double totalPrice = ticket.getTotalPrice();

        printStrigMessage("Reserva encontrada en el hotel: " + hotel.getName());
        printStrigMessage("Usuario: " + user.getFirstName() + " " + user.getLastName());
        printStrigMessage("Correo: " + user.getEmail());
        printStrigMessage("Teléfono: " + user.getPhone());
        printStrigMessage("Habitación actual: " + room.getType() + " - $" + room.getPrice());
        printStrigMessage("Habitación precio total: $" + totalPrice);
        printStrigMessage("Descripción: " + room.getDescription());
        printSeparator();
        printStrigMessage("¿Desea cambiar de habitación o alojamiento? (Room/Hotel)");
    }
}
