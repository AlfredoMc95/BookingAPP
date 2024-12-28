package com.bookingapp.views;
import java.util.Scanner;
import com.bookingapp.controllers.Booking;

import static com.bookingapp.controllers.UpdateBooking.updateBooking;
import static com.bookingapp.utilities.PrintMessage.printStrigMessage;

public class UpdateBookingData {
    // 4
    public static void updateBookingData()
    {
        Scanner scanner = new Scanner(System.in);
        String email;
        String birthdate;

        printStrigMessage("Ingrese email:");
        email = scanner.nextLine();
        printStrigMessage("Ingrese fecha de nacimiento:");
        birthdate = scanner.nextLine();

        updateBooking( email, birthdate);
    }
}
