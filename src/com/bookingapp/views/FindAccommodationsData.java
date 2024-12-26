package com.bookingapp.views;

import java.util.Scanner;
import com.bookingapp.controllers.Booking;

public class FindAccommodationsData {
    //1.
    public static void findAccommodationsData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese nombre de la ciudad:");
        String city = scanner.nextLine();
        System.out.println("Ingrese tipo de alojamiento:");
        String type = scanner.nextLine();
        System.out.println("Ingrese dia de inicio:");
        int checkIn = scanner.nextInt();
        System.out.println("Ingrese dia de fin:");
        int checkOut = scanner.nextInt();
        System.out.println("Ingrese adultos:");
        int adults = scanner.nextInt();
        System.out.println("Ingrese niños:");
        int children = scanner.nextInt();
        System.out.println("Ingrese habitaciones:");
        int rooms = scanner.nextInt();

        Booking.printResults(city, type, checkIn, checkOut, adults, children, rooms);
    }
}
