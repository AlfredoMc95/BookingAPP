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

    public void printResults(String city, String type, int checkIn, int checkOut, int adults, int children, int rooms) {
        List<Object> results = findAccommodations(city, type, checkIn, checkOut, adults, children, rooms);

        if (results.isEmpty()) {
            System.out.println("No se encontraron resultados.");
        } else {
            for (Object result : results) {
                if (result instanceof Hotel) {
                    Hotel hotel = (Hotel) result;
                    double totalPrice = hotel.totalPriceSum(rooms, checkIn);
                    double discount = hotel.totalPriceDiscount(checkIn);

                    // Imprimir información del hotel
                    System.out.println("Nombre: " + hotel.getName());
                    System.out.println("Calificación: " + hotel.getRate());
                    System.out.println("Precio por noche: $" + hotel.getPricePerNight());
                    System.out.println("Descuento/Recargo aplicado: $" + discount);
                    System.out.println("Precio total: $" + totalPrice);
                    System.out.println("------------------------");
                } else if (result instanceof DayOfSun) {
                    DayOfSun dayOfSun = (DayOfSun) result;
                    System.out.println("Nombre: " + dayOfSun.getName());
                    System.out.println("Actividades disponibles:");
                    dayOfSun.showActivity();
                    System.out.println("Precio: $" + dayOfSun.totalPriceSum(rooms,checkIn));
                    System.out.println("------------------------");
                }else if(result instanceof Aparment){
                    Aparment aparment = (Aparment) result;
                    double totalPrice = aparment.totalPriceSum(rooms, checkIn);
                    double discount = aparment.totalPriceDiscount(checkIn);

                    // Imprimir información del hotel
                    System.out.println("Nombre: " + aparment.getName());
                    System.out.println("Calificación: " + aparment.getRate());
                    System.out.println("Precio por noche: $" + aparment.getPricePerNight());
                    System.out.println("Descuento/Recargo aplicado: $" + discount);
                    System.out.println("Precio total: $" + totalPrice);
                    System.out.println("------------------------");
                }
            }
        }
    }



}