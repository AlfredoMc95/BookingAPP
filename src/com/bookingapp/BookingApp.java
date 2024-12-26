package com.bookingapp;

import com.bookingapp.controllers.Booking;
import com.bookingapp.views.*;
import com.bookingapp.utilities.DataInitializer;

public class BookingApp {

    public static void main(String[] args) {
        // Inicializar datos
        Booking.accommodations = DataInitializer.initializeAccommodations();
        Booking.dayOfSunOptions = DataInitializer.initializeDayOfSun();

        // Recordatorio testing de que sirva
        MainMenuDisplay mainMenuDisplay = new MainMenuDisplay();
        mainMenuDisplay.mainMenuDisplay();


        // Recordatorio poner esto en otro Scrypt es decir agregar la view main menu y desde hay ejecutar toda esta loguica en orden y luego llamrla aqui
        // Buscar alojamientos
        //FindAccommodationsData.findAccommodationsData();
        // buscar cuartos disponibles en el hotel
        //HotelShowRoomsData.hotelShowRoomsData();
        // no estoy seguro de que esto sea una buena práctica
        // hago reserva, pedirá datos del hotel y creará un usuario con los datos que pedirá del usuario después
        //ReservationData.reservationData(null);
        // actualizo reserva
        //UpdateBookingData.updateBookingData();

    }
}
