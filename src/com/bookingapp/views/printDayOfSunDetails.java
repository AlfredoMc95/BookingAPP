package com.bookingapp.views;

import com.bookingapp.models.DayOfSun;

import static com.bookingapp.utilities.PrintMessage.printSeparator;
import static com.bookingapp.utilities.PrintMessage.printStrigMessage;

public class printDayOfSunDetails {
    public static void printDayOfSunDetails(DayOfSun dayOfSun) {
        printStrigMessage("Nombre: " + dayOfSun.getName());
        printStrigMessage("Actividades disponibles:");
        dayOfSun.showActivity();
        printStrigMessage("Precio: $" + dayOfSun.getPricePerNight());
        printSeparator();
    }
}
