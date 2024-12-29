package com.bookingapp.views;

import com.bookingapp.controllers.Booking;
import com.bookingapp.models.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static com.bookingapp.controllers.MakeReservation.makeReservation;
import static com.bookingapp.utilities.PrintMessage.printStrigMessage;

public class ReservationData {
    // 3
    public static void reservationData(User user){
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
        scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate checkIn = LocalDate.parse(checkInDate, formatter);
        LocalDate checkOut = LocalDate.parse(checkOutDate, formatter);

        if(user == null) {

            printStrigMessage("Ingrese nombre del usuario:");
            String name = scanner.nextLine();
            printStrigMessage("Ingrese apellido del usuario:");
            String lastName = scanner.nextLine();
            printStrigMessage("Ingrese email del usuario:");
            String email = scanner.nextLine();
            printStrigMessage("Ingrese nacionalidad del usuario:");
            String nacionalidad = scanner.nextLine();
            printStrigMessage("Ingrese teléfono del usuario:");
            String phone = scanner.nextLine();
            printStrigMessage("Ingrese fecha de nacimiento del usuario(dd-mm-aaaa):");
            String fecha = scanner.nextLine();
            User userInfo = new User(name,lastName,email,nacionalidad,phone,fecha);
            makeReservation(hotelName,checkIn,checkOut,adults,children,rooms,userInfo);
        }else{
            makeReservation(hotelName,checkIn,checkOut,adults,children,rooms,user);
        }
    }
}
