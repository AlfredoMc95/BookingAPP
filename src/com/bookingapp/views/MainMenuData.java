package com.bookingapp.views;

import static com.bookingapp.utilities.PrintMessage.printSeparator;
import static com.bookingapp.utilities.PrintMessage.printStrigMessage;

public class MainMenuData {

    public static void mainMenu(){
        printStrigMessage("Bienvenido a la aplicación de reserva de alojamiento.");
        printStrigMessage("Ingrese 1 para buscar alojamientos.");
        printStrigMessage("Ingrese 2 para buscar habitaciones de un hotel.");
        printStrigMessage("Ingrese 3 para reservar alojamiento.");
        printStrigMessage("Ingrese 4 para actualizar reserva.");
        printStrigMessage("Ingrese 5 para salir.");
        printSeparator();
    }
}