package com.bookingapp.controllers;

import com.bookingapp.models.BookingTicket;
import com.bookingapp.models.Hotel;
import com.bookingapp.models.Room;

import java.util.Scanner;

import static com.bookingapp.utilities.PrintMessage.*;
import static com.bookingapp.views.ReservationView.reservationView;


public class UpdateRoom {
    public static void updateRoom(BookingTicket ticketToUpdate, Hotel hotelWithBooking) {
        Scanner scanner = new Scanner(System.in);

        printStrigMessage("Habitaciones disponibles en el hotel " + hotelWithBooking.getName() + ":");
        hotelWithBooking.displayAvailableRooms();

        printStrigMessage("Ingrese el tipo de habitación deseada:");
        String newRoomType = scanner.nextLine();

        // Buscar una nueva habitación en el mismo hotel
        Room newRoom = hotelWithBooking.getRooms().stream()
                .filter(r -> r.isAvailable() && r.getType().equalsIgnoreCase(newRoomType))
                .findFirst()
                .orElse(null);

        if (newRoom == null) {
            printNotFound();
            printSeparator();
            return;
        }

        Room currentRoom = ticketToUpdate.getRoom();
        updateRoomAvailability(currentRoom, newRoom);
        ticketToUpdate.setRoom(newRoom);

        reservationView(newRoom, ticketToUpdate.getTotalPrice());
    }

    private static void updateRoomAvailability(Room currentRoom, Room newRoom) {
        if (currentRoom != null) {
            currentRoom.setAvailable(true);
        }
        newRoom.setAvailable(false);
    }

}
