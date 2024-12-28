package com.bookingapp.views;
import java.util.Scanner;
import com.bookingapp.controllers.Booking;

import static com.bookingapp.controllers.PrintAccommodationResults.printResults;
import static com.bookingapp.utilities.PrintMessage.printStrigMessage;

public class FindAccommodationsData {
    //1.
    public static void findAccommodationsData() {
        Scanner scanner = new Scanner(System.in);

        printStrigMessage("Ingrese nombre de la ciudad:");
        String city = scanner.nextLine();
        printStrigMessage("Ingrese tipo de alojamiento:");
        String type = scanner.nextLine();
        printStrigMessage("Ingrese dia de inicio:");
        int checkIn = scanner.nextInt();
        printStrigMessage("Ingrese dia de fin:");
        int checkOut = scanner.nextInt();
        printStrigMessage("Ingrese adultos:");
        int adults = scanner.nextInt();
        printStrigMessage("Ingrese niños:");
        int children = scanner.nextInt();
        printStrigMessage("Ingrese habitaciones:");
        int rooms = scanner.nextInt();

        printResults(city, type, checkIn, checkOut, adults, children, rooms);
    }
}
