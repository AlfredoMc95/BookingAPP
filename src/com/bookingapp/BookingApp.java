package com.bookingapp;

import com.bookingapp.controllers.Booking;
import com.bookingapp.views.FindAccommodationsData;
import com.bookingapp.views.HotelShowRoomsData;
import com.bookingapp.views.ReservationData;
import com.bookingapp.views.UpdateBookingData;
import com.bookingapp.utilities.DataInitializer;

public class BookingApp {

    public static void main(String[] args) {
        // Inicializar datos
        Booking.accommodations = DataInitializer.initializeAccommodations();
        Booking.dayOfSunOptions = DataInitializer.initializeDayOfSun();

        // Recordatorio poner esto en otro Scrypt
        // Buscar alojamientos
        FindAccommodationsData.findAccommodationsData();
        // buscar cuartos disponibles en el hotel
        HotelShowRoomsData.hotelShowRoomsData();
        // no estoy seguro de que esto sea una buena práctica
        // hago reserva, pedirá datos del hotel y creará un usuario con los datos que pedirá del usuario después
        ReservationData.reservationData(null);
        // actualizo reserva
        UpdateBookingData.updateBookingData();

    }
}
