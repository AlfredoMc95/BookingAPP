package com.bookingapp.views;


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
        int checkIn = scanner.nextInt();
        printStrigMessage("Ingrese dia de fin:");
        int checkOut = scanner.nextInt();
        printStrigMessage("Ingrese adultos:");
        int adults = scanner.nextInt();
        printStrigMessage("Ingrese niños:");
        int children = scanner.nextInt();
        printStrigMessage("Ingrese habitaciones:");
        int rooms = scanner.nextInt();

        Booking.showRooms(hotelName,checkIn,checkOut,adults,children,rooms);
    }


}
