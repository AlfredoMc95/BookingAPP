package com.bookingapp.views;

import java.util.Scanner;

public class MainMenuDisplay {
    public void mainMenuDisplay() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {

            System.out.println("Bienvenido a la aplicación de reserva de alojamiento.");
            System.out.println("Ingrese 1 para buscar alojamientos.");
            System.out.println("Ingrese 2 para buscar habitaciones de un hotel.");
            System.out.println("Ingrese 3 para reservar alojamiento.");
            System.out.println("Ingrese 4 para actualizar reserva.");
            System.out.println("Ingrese 5 para salir.");
            System.out.println("------------------------");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    FindAccommodationsData.findAccommodationsData();
                    break;
                case 2:
                    HotelShowRoomsData.hotelShowRoomsData();
                    break;
                case 3:
                    ReservationData.reservationData(null);
                    break;
                case 4:
                    UpdateBookingData.updateBookingData();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
            System.out.println("------------------------");
            System.out.println();
        }
        scanner.close();
    }

}
