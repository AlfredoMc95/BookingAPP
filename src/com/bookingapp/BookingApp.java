package com.bookingapp;

import com.bookingapp.models.*;

import java.util.ArrayList;
import java.util.List;

public class BookingApp {
    public static void main(String[] args) {
        // Crear habitaciones para el primer hotel
        // Suite,Junior suite,Gran suite,Individuales,Dobles

        List<Room> hotelSolRooms = new ArrayList<>();
        hotelSolRooms.add(new Room("Simple", 100, "Habitación básica", true));
        hotelSolRooms.add(new Room("Doble", 50, "Habitación para dos", true));
        hotelSolRooms.add(new Room("Doble", 150, "Habitación para dos", true));

        // Crear habitaciones para el segundo hotel
        List<Room> hotelLunaRooms = new ArrayList<>();
        hotelLunaRooms.add(new Room("Simple", 120, "Habitación estándar", true));
        hotelLunaRooms.add(new Room("Suite", 300, "Habitación de lujo", true));

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

        // user
        User user = new User("Juan","martinez","Juan@gmail.com","Colombia","3058965412","02-10-1995");

        // Sistema de reservas
        Booking booking = new Booking(accommodations, dayOfSunOptions);

        // Buscar alojamientos
        booking.printResults("Medellín", "Hotel", 5, 10, 2, 1, 1);

        booking.showRooms("Hotel luna",  5, 10, 2, 1, 1);

        booking.makeReservation("Hotel Sol",  5, 10, 2, 1, 1,user);

    }
}
