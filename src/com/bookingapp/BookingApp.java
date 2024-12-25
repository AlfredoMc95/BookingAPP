package com.bookingapp;

import com.bookingapp.models.*;

import java.util.ArrayList;
import java.util.List;

public class BookingApp {
    public static void main(String[] args) {
        // Crear habitaciones para el primer hotel
        // Suite, Junior suite, Gran suite, Individuales, Dobles

        List<Room> hotelSolRooms = new ArrayList<>();
        hotelSolRooms.add(new Room("Suite", 300, "Amplia habitación con sala de estar, jacuzzi y vista panorámica", true));
        hotelSolRooms.add(new Room("Junior Suite", 200, "Habitación cómoda con área de descanso y balcón privado", true));
        hotelSolRooms.add(new Room("Doble", 150, "Habitación para dos personas con cama matrimonial y escritorio", true));
        hotelSolRooms.add(new Room("Gran Suite", 400, "Habitación de lujo con dos dormitorios, sala privada y terraza", true));
        hotelSolRooms.add(new Room("Individual", 100, "Habitación acogedora para una persona, incluye escritorio y TV", true));
        hotelSolRooms.add(new Room("Gran Suite", 450, "Suite exclusiva con vistas espectaculares, cocina privada y baño de lujo", true));

        // Crear habitaciones para el segundo hotel
        List<Room> hotelLunaRooms = new ArrayList<>();
        hotelLunaRooms.add(new Room("Doble", 150, "Habitación para dos personas con cama matrimonial y escritorio", true));
        hotelLunaRooms.add(new Room("Gran Suite", 400, "Habitación de lujo con dos dormitorios, sala privada y terraza", true));
        hotelLunaRooms.add(new Room("Individual", 100, "Habitación acogedora para una persona, incluye escritorio y TV", true));
        hotelLunaRooms.add(new Room("Gran Suite", 450, "Suite exclusiva con vistas espectaculares, cocina privada y baño de lujo", true));

        // Crear actividades
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Natación", "Disfruta de una piscina olímpica"));
        activities.add(new Activity("Senderismo", "Explora senderos naturales"));

        // Crear alojamientos
        Hotel hotelSol = new Hotel("Hotel Sol", 4, 200, "Medellín", hotelSolRooms);
        Hotel hotelLuna = new Hotel("Hotel Luna", 5, 250, "Medellín", hotelLunaRooms);
        Aparment mazuren = new Aparment("mazuren",2,"Bogota",250);

        DayOfSun dayOfSun = new DayOfSun("Parque Sol",50, activities,"Medellín", true);

        List<AccomodationBase> accommodations = new ArrayList<>();
        accommodations.add(hotelSol);
        accommodations.add(hotelLuna);
        accommodations.add(mazuren);

        List<DayOfSun> dayOfSunOptions = new ArrayList<>();
        dayOfSunOptions.add(dayOfSun);

        // Sistema de reservas
        Booking booking = new Booking(accommodations, dayOfSunOptions);


        // Recordatorio poner esto en otro Scrypt
        // Buscar alojamientos
        booking.findAccommodationsData();
        // buscar cuartos disponibles en el hotel
        booking.hotelshowRoomsData();
        // no estooy seguro de que esto sea una buena practica
        // hago reserva, pedira datos del hotel y creara un usuario con los datos que pedira del usuario despues
        booking.reservationData(null);
        // actualizo reserva
        booking.updateBookingData();

    }
}
