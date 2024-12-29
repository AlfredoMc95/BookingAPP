package com.bookingapp.views;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.bookingapp.controllers.Booking;

import static com.bookingapp.utilities.PrintMessage.printStrigMessage;

public class HotelShowRoomsData {
    //2.
    public static void hotelShowRoomsData() {
        Scanner scanner = new Scanner(System.in);

        printStrigMessage("Ingrese nombre del hotel:");
        String hotelName = scanner.nextLine();
        printStrigMessage("Ingrese dia de inicio:");
        String checkInDate = scanner.nextLine();
        printStrigMessage("Ingrese dia de fin:");
        String checkOutDate = scanner.nextLine();
        printStrigMessage("Ingrese adultos:");
        int adults = scanner.nextInt();
        printStrigMessage("Ingrese niños:");
        int children = scanner.nextInt();
        printStrigMessage("Ingrese habitaciones:");
        int rooms = scanner.nextInt();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate checkIn = LocalDate.parse(checkInDate, formatter);
        LocalDate checkOut = LocalDate.parse(checkOutDate, formatter);

        Booking.showRooms(hotelName,checkIn,checkOut,adults,children,rooms);
    }


}
