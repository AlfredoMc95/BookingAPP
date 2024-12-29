package com.bookingapp.controllers;
import com.bookingapp.models.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static com.bookingapp.utilities.PrintMessage.*;

public class Booking {
    public static List<AccommodationBase> accommodations = new ArrayList<>();

    public static List<AccommodationBase> findAccommodations(String city, String type, LocalDate checkIn, LocalDate checkOut, int adults, int children, int rooms) {
        return accommodations.stream()
                .filter(accommodation -> accommodation.getCity().equalsIgnoreCase(city))
                .filter(accommodation -> matchesTypeAndAvailability(accommodation, type, rooms))
                .toList();
    }

    private static boolean matchesTypeAndAvailability(AccommodationBase accommodation, String type, int rooms) {
        return switch (type.toLowerCase()) {
            case "hotel" -> accommodation instanceof Hotel hotel && hasAvailableRooms(hotel, rooms);
            case "apartamento" -> accommodation instanceof Apartment;
            case "finca" -> accommodation instanceof Estate;
            case "dia de sol" -> accommodation instanceof DayOfSun;
            default -> false;
        };
    }

    public static List<Object> findAccommodationsByName(String name, int rooms) {
        List<Object> results = new ArrayList<>();

        for (AccommodationBase accommodation : accommodations) {
            if (!accommodation.getName().equalsIgnoreCase(name)) continue;

            if (accommodation instanceof Hotel hotel && hasAvailableRooms(hotel, rooms)) {
                results.add(hotel);
            }
        }
        return results;
    }

    private static List<Room> getAvailableRooms(Hotel hotel) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : hotel.getRooms()) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    private static boolean hasAvailableRooms(Hotel hotel, int requiredRooms) {
        return getAvailableRooms(hotel).size() >= requiredRooms;
    }

    public static void showRooms(String hotelName, LocalDate checkIn, LocalDate checkOut, int adults, int children, int rooms){
        List<Object> results = findAccommodationsByName(hotelName, rooms);
        if (results.isEmpty()) {
            printNotFound();
        } else {
            for (Object result : results) {
                if (result instanceof Hotel hotel) {
                    hotel.displayAvailableRooms();
                }
            }
        }
    }
}