package com.bookingapp.models;

import com.bookingapp.utilities.IAccommodation;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private List<AccomodationBase> accommodations;
    private List<DayOfSun> dayOfSunOptions;

    public Booking(List<AccomodationBase> accommodations, List<DayOfSun> dayOfSunOptions) {
        this.accommodations = accommodations;
        this.dayOfSunOptions = dayOfSunOptions;
    }

    public List<Object> findAccommodations(String city, String type, int checkIn, int checkOut, int adults, int children, int rooms) {
        List<Object> results = new ArrayList<>();

        if (type.equalsIgnoreCase("Dia de sol")) {
            for (DayOfSun dayOfSun : dayOfSunOptions) {
                if (dayOfSun.getCity().equalsIgnoreCase(city)) {
                    results.add(dayOfSun);
                }
            }
        } else {
            for (AccomodationBase accommodation : accommodations) {
                if (!accommodation.getCity().equalsIgnoreCase(city)) continue;

                if (type.equalsIgnoreCase("Hotel") && accommodation instanceof Hotel) {
                    Hotel hotel = (Hotel) accommodation;
                    if (hasAvailableRooms(hotel, rooms)) {
                        results.add(hotel);
                    }
                } else if (type.equalsIgnoreCase("Apartamento") && accommodation instanceof Aparment) {
                    results.add(accommodation);
                } else if (type.equalsIgnoreCase("Finca") && accommodation instanceof Estate) {
                    results.add(accommodation);
                }
            }
        }

        return results;
    }

    private boolean hasAvailableRooms(Hotel hotel, int requiredRooms) {
        int availableRooms = 0;
        for (Room room : hotel.getRooms()) {
            if (room.isAvailable()) {
                availableRooms++;
            }
        }
        return availableRooms >= requiredRooms;
    }
}
