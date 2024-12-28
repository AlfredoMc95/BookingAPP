package com.bookingapp.views;

import com.bookingapp.models.Room;

import static com.bookingapp.utilities.PrintMessage.printSeparator;
import static com.bookingapp.utilities.PrintMessage.printStrigMessage;

public class ReservationView {
    public static void reservationView(Room newRoom, double totalPrice) {
        printStrigMessage("¡La reserva ha sido actualizada con éxito!");
        printStrigMessage("Nueva habitación: " + newRoom.getType() + " - $" + newRoom.getPrice());
        printStrigMessage("Descripción: " + newRoom.getDescription());
        printStrigMessage("Habitación precio total: $" + totalPrice);
        printSeparator();
    }
}
