package com.bookingapp.utilities;

import java.util.ArrayList;
import java.util.List;
import com.bookingapp.models.*;

public class DataInitializer {
    public static List<AccommodationBase> initializeAccommodations() {
        // Crear habitaciones para el primer hotel
        List<Room> hotelSolRooms = new ArrayList<>();
        hotelSolRooms.add(new Room("Suite", 300, "Amplia habitación con sala de estar, jacuzzi y vista panorámica", true));
        hotelSolRooms.add(new Room("Junior Suite", 200, "Habitación cómoda con área de descanso y balcón privado", true));
        hotelSolRooms.add(new Room("Doble", 150, "Habitación para dos personas con cama matrimonial y escritorio", true));
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

        // Crear hoteles
        Hotel hotelSol = new Hotel("Hotel Sol", 4, 200, "Medellín", hotelSolRooms);
        Hotel hotelLuna = new Hotel("Hotel Luna", 5, 250, "Medellín", hotelLunaRooms);

        // Crear apartamentos
        Apartment mazuren = new Apartment("Mazuren", 2, "Bogota", 250);

        // Crear Day of Sun
        DayOfSun dayOfSun = new DayOfSun("Parque Sol",5, "Medellín",50,activities,true);


        // Crear lista de alojamientos
        List<AccommodationBase> accommodations = new ArrayList<>();
        accommodations.add(hotelSol);
        accommodations.add(hotelLuna);
        accommodations.add(mazuren);
        accommodations.add(dayOfSun);

        return accommodations;
    }
}
