package com.bookingapp.utilities;

import com.bookingapp.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bookingapp.utilities.PrintMessage.printStrigMessage;

public class AccommodationFactory {

    private static final Map<String, AccommodationBase> accommodations = new HashMap<>();

    // obtener hotel
    public static Hotel getHotel(String name, int rate, double pricePerNight, String city, List<Room> rooms) {
        String key = generateKey(name, rate,  city);

        if (!accommodations.containsKey(key)) {
            accommodations.put(key, new Hotel(name, rate, pricePerNight, city, rooms));
        }

        return (Hotel) accommodations.get(key);
    }

    // obtener aptos
    public static Apartment getApartment(String name, int rate, String city, double pricePerNight) {
        String key = generateKey(name, rate,  city);

        return (Apartment) accommodations.computeIfAbsent(key, k ->new Apartment(name, rate, city, pricePerNight));
    }

    // obtener dia de sol
    public static DayOfSun getDayOfSun(String name, int rate, String city, double pricePerNight, List<Activity> activities, boolean lunchIsInclude) {
        String key = generateKey(name, rate,  city);

        accommodations.computeIfAbsent(key, k -> new DayOfSun(name, rate, city, pricePerNight, activities, lunchIsInclude));

        return (DayOfSun) accommodations.get(key);
    }

    private static String generateKey(String name, int rate,String city) {
        return "Nombre: "+name.toLowerCase() + " Rate: " + rate + " Ciudad: " + city;
    }

    // listar todos los alojamientos que tiene el factory
    public static void listAllAccommodations() {
        accommodations.forEach((key, accommodation) -> {

            String accommodationType = "";
            if (accommodation instanceof Hotel) {
                accommodationType = "Hotel";
            } else if (accommodation instanceof Apartment) {
                accommodationType = "Apartamento";
            } else if (accommodation instanceof DayOfSun) {
                accommodationType = "Día de Sol";
            } else if (accommodation instanceof Estate) {
                accommodationType = "Finca";
            }

            printStrigMessage("- " + key  + ", Tipo: " + accommodationType);

        });
    }

    // retorna todas las instancias creadas para eel filtrado por hotel
    public static List<AccommodationBase> getAllAccommodations() {
        return new ArrayList<>(accommodations.values());
    }
}
