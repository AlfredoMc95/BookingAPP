package com.bookingapp.views;

import com.bookingapp.models.Hotel;
import com.bookingapp.models.Room;
import com.bookingapp.models.User;

import static com.bookingapp.utilities.PrintMessage.printSeparator;
import static com.bookingapp.utilities.PrintMessage.printStrigMessage;

public class PrintConfirmReservation {
    public static void printConfirmReservation(Hotel hotel, User userInfo, Room room, double totalPrice) {

        printStrigMessage("Reserva confirmada");
        printStrigMessage("Hotel: " + hotel.getName());
        printStrigMessage("Usuario: " + userInfo.getFirstName() + " " + userInfo.getLastName());
        printStrigMessage("Tipo de habitación: " + room.getType());
        printStrigMessage("Descripción: " + room.getDescription());
        printStrigMessage("Precio: $" + totalPrice);
        printSeparator();
    }
}
