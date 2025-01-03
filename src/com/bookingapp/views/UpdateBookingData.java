package com.bookingapp.views;
import com.bookingapp.utilities.BookingMediator;

import java.util.Scanner;

import static com.bookingapp.utilities.PrintMessage.printStrigMessage;

public class UpdateBookingData {
    private static final BookingMediator mediator = BookingMediator.getInstance();
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

        mediator.updateBooking( email, birthdate);
    }
}
