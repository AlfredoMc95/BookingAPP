package com.bookingapp.views;

import com.bookingapp.models.User;
import com.bookingapp.controllers.Booking;

import java.util.Scanner;

public class ReservationData {
    // 3
    public static void reservationData(User user){
        Scanner scanner = new Scanner(System.in);
        String hotelName;
        int checkIn;
        int checkOut;
        int adults;
        int children;
        int rooms;

        System.out.println("Ingrese nombre del hotel:");
        hotelName = scanner.nextLine();
        System.out.println("Ingrese dia de inicio:");
        checkIn = scanner.nextInt();
        System.out.println("Ingrese dia de fin:");
        checkOut = scanner.nextInt();
        System.out.println("Ingrese adultos:");
        adults = scanner.nextInt();
        System.out.println("Ingrese niños:");
        children = scanner.nextInt();
        System.out.println("Ingrese habitaciones:");
        rooms = scanner.nextInt();
        scanner.nextLine();

        if(user == null) {
            System.out.println("Ingrese nombre del usuario:");
            String name = scanner.nextLine();
            System.out.println("Ingrese apellido del usuario:");
            String las = scanner.nextLine();
            System.out.println("Ingrese email del usuario:");
            String email = scanner.nextLine();
            System.out.println("Ingrese nacionalidad del usuario:");
            String nacionalidad = scanner.nextLine();
            System.out.println("Ingrese telefono del usuario:");
            String telefono = scanner.nextLine();
            System.out.println("Ingrese fecha de nacimiento del usuario(dd-mm-aaaa):");
            String fecha = scanner.nextLine();
            User userInfo = new User(name,las,email,nacionalidad,telefono,fecha);
            Booking.makeReservation(hotelName,checkIn,checkOut,adults,children,rooms,userInfo);
        }else{
            Booking.makeReservation(hotelName,checkIn,checkOut,adults,children,rooms,user);
        }
    }
}
