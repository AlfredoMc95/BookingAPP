package com.bookingapp.views;

import com.bookingapp.models.Apartment;

import java.time.LocalDate;

import static com.bookingapp.utilities.PrintMessage.printSeparator;
import static com.bookingapp.utilities.PrintMessage.printStrigMessage;

public class PrintApartmentDetails {
    public static void printApartmentDetails(Apartment apartment, int rooms, LocalDate checkIn) {
        double totalPrice = apartment.calculateTotalPrice(rooms, checkIn);
        double discount = apartment.totalPriceDiscount(checkIn);
        printStrigMessage("Nombre: " + apartment.getName());
        printStrigMessage("Calificación: " + apartment.getRate());
        printStrigMessage("Precio por noche: $" + apartment.getPricePerNight());
        printStrigMessage("Descuento/Recargo aplicado: $" + discount);
        printStrigMessage("Precio total: $" + totalPrice);
        printStrigMessage("habitaciones: " + rooms);
        printSeparator();
    }
}
