package com.bookingapp.views;

import com.bookingapp.models.Hotel;

import static com.bookingapp.utilities.PrintMessage.printSeparator;
import static com.bookingapp.utilities.PrintMessage.printStrigMessage;

public class PrintHotelDetails {
    public static void printHotelDetails(Hotel hotel, int rooms, int checkIn) {
        double totalPrice = hotel.calculateTotalPrice(rooms, checkIn);
        double discount = hotel.totalPriceDiscount(checkIn);
        printStrigMessage("Nombre: " + hotel.getName());
        printStrigMessage("Calificación: " + hotel.getRate());
        printStrigMessage("Precio por noche: $" + hotel.getPricePerNight());
        printStrigMessage("Descuento/Recargo aplicado: $" + discount);
        printStrigMessage("Precio total: $" + totalPrice);
        printStrigMessage("habitaciones: " + rooms);
        printSeparator();
    }
}
