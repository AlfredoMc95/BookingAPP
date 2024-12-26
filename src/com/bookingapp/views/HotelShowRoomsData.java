package com.bookingapp.views;


import java.util.Scanner;
import com.bookingapp.controllers.Booking;

public class HotelShowRoomsData {
    //2.
    public static void hotelShowRoomsData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese nombre del hotel:");
        String hotelName = scanner.nextLine();
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

        Booking.showRooms(hotelName,checkIn,checkOut,adults,children,rooms);
    }


}
