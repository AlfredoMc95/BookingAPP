package com.bookingapp.views;

import java.util.Scanner;
import com.bookingapp.controllers.Booking;

public class UpdateBookingData {
    // 4
    public static void updateBookingData()
    {
        Scanner scanner = new Scanner(System.in);
        String email;
        String birthdate;

        System.out.println("Ingrese email:");
        email = scanner.nextLine();
        System.out.println("Ingrese fecha de nacimiento:");
        birthdate = scanner.nextLine();

        Booking.updateBooking( email, birthdate);
    }
}
