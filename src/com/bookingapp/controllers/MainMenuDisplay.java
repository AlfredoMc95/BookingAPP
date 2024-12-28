package com.bookingapp.controllers;

import com.bookingapp.views.FindAccommodationsData;
import com.bookingapp.views.HotelShowRoomsData;
import com.bookingapp.views.ReservationData;
import com.bookingapp.views.UpdateBookingData;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.bookingapp.utilities.PrintMessage.*;
import static com.bookingapp.views.MainMenuData.mainMenu;

public class MainMenuDisplay {
    public void mainMenuDisplay() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            mainMenu();
            int option = scanner.nextInt();
            exit = handleMenuOption(option);
        }
    }

    private boolean handleMenuOption(int option) {
        Map<Integer, Runnable> menuActions = createMenuActionsMap();

        Runnable action = menuActions.get(option);
        if (action != null) {
            action.run();
        } else {
            printStrigMessage("Cerrando aplicación");
        }

        printSeparator();
        return option == 5;
    }

    private Map<Integer, Runnable> createMenuActionsMap() {
        Map<Integer, Runnable> menuActions = new HashMap<>();
        menuActions.put(1, FindAccommodationsData::findAccommodationsData);
        menuActions.put(2, HotelShowRoomsData::hotelShowRoomsData);
        menuActions.put(3, () -> ReservationData.reservationData(null));
        menuActions.put(4, UpdateBookingData::updateBookingData);
        return menuActions;
    }
}
