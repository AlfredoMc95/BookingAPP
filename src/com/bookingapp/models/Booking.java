package com.bookingapp.models;

import com.bookingapp.utilities.IAccommodation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Booking {
    private List<AccomodationBase> accommodations;
    private List<DayOfSun> dayOfSunOptions;

    public Booking(List<AccomodationBase> accommodations, List<DayOfSun> dayOfSunOptions) {
        this.accommodations = accommodations;
        this.dayOfSunOptions = dayOfSunOptions;
    }

    // encuentra typo de establecimiento día sol, hotel, apartamento y finca
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

    //encuentra SOLO HOTEL por nombre
    public List<Object> findAccommodationsByName(String name, int checkIn, int checkOut, int adults, int children, int rooms) {
        List<Object> results = new ArrayList<>();

        for (AccomodationBase accommodation : accommodations) {
            if (!accommodation.getName().equalsIgnoreCase(name)) continue;

            if (accommodation instanceof Hotel) {
                Hotel hotel = (Hotel) accommodation;
                if (hasAvailableRooms(hotel, rooms)) {
                    results.add(hotel);
                }
            }
        }

        return results;
    }

    // reserva en hotel
    public void makeReservation(String hotelName, int checkIn, int checkOut, int adults, int children, int rooms, User userInfo){
        List<Object> results = findAccommodationsByName(hotelName, checkIn, checkOut, adults, children, rooms);

        if (results.isEmpty()) {
            System.out.println("No se encontraron resultados.");
        } else {
            for (Object result : results) {
                if (result instanceof Hotel) {
                    Hotel hotel = (Hotel) result;
                    double totalPrice = hotel.totalPriceSum(rooms, checkIn);

                    Room cheapestRoom = null;
                    for (Room room : hotel.getRooms()) {
                        if (room.isAvailable() && (cheapestRoom == null || room.getPrice() < cheapestRoom.getPrice())) {
                            cheapestRoom = room;
                        }
                    }

                    if (cheapestRoom != null) {
                        cheapestRoom.setAvailable(false);
                        System.out.println("Reserva confirmada:");
                        System.out.println("Hotel: " + hotel.getName());
                        System.out.println("Tipo de habitación: " + cheapestRoom.getType());
                        System.out.println("descripcion: " + cheapestRoom.getDescription());
                        System.out.println("Precio: $" + totalPrice);
                        BookingTicket bookingTicket = new BookingTicket(userInfo, cheapestRoom, totalPrice);
                        hotel.addBookingTicket(bookingTicket);
                        System.out.println("------------------------");
                    } else {
                        System.out.println("No hay habitaciones disponibles en el hotel: " + hotel.getName());
                        System.out.println("------------------------");
                    }
                }
            }
        }
    }

    private List<Room> getAvailableRooms(Hotel hotel) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : hotel.getRooms()) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    private boolean hasAvailableRooms(Hotel hotel, int requiredRooms) {
        return getAvailableRooms(hotel).size() >= requiredRooms;
    }

    public void showRooms(String hotelName, int checkIn, int checkOut, int adults, int children, int rooms){
        List<Object> results = findAccommodationsByName(hotelName, checkIn, checkOut, adults, children, rooms);
        if (results.isEmpty()) {
            System.out.println("No se encontraron resultados.");
        } else {
            for (Object result : results) {
                if (result instanceof Hotel) {
                    Hotel hotel = (Hotel) result;
                    // Imprimir información del hotel
                    hotel.showRooms();
                }
            }
        }
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
                    System.out.println("habitaciones: " + rooms);
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
                    System.out.println("habitaciones: " + rooms);
                    System.out.println("------------------------");
                }
            }
        }
    }

    // ticket se actualiza
    public void updateBooking(String email, String birthdate) {
        Scanner scanner = new Scanner(System.in);
        BookingTicket ticketToUpdate = null;
        Hotel hotelWithBooking = null;

        for (AccomodationBase accommodation : accommodations) {
            if (accommodation instanceof Hotel) {
                Hotel hotel = (Hotel) accommodation;
                for (BookingTicket ticket : hotel.getBookingTicket()) {
                    if (ticket.getUser().getEmail().equalsIgnoreCase(email) &&
                            ticket.getUser().getBirthdate().equalsIgnoreCase(birthdate)) {
                        ticketToUpdate = ticket;
                        hotelWithBooking = hotel;
                        break;
                    }
                }
            }
            if (ticketToUpdate != null) break;
        }

        if (ticketToUpdate == null) {
            System.out.println("No se encontró ninguna reserva.");
            return;
        }

        User user = ticketToUpdate.getUser();
        Room room = ticketToUpdate.getRoom();
        double totalPrice = ticketToUpdate.getTotalPrice();
        System.out.println("Reserva encontrada en el hotel: " + hotelWithBooking.getName());
        System.out.println("Usuario: " + user.getFirstName() + " " + user.getLastName());
        System.out.println("Correo: " + user.getEmail());
        System.out.println("Teléfono: " + user.getPhone());
        System.out.println("Habitación actual: " + room.getType() + " - $" + room.getPrice());
        System.out.println("Habitación precio total: $" + totalPrice);
        System.out.println("Descripción: " + room.getDescription());


        System.out.println("¿Desea cambiar de habitación o alojamiento? (Room/Hotel)");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("Room")) {
            System.out.println("Ingrese el tipo de habitación deseada:");
            String newRoomType = scanner.nextLine();

            // Buscar una nueva habitación en el mismo hotel
            Room newRoom = hotelWithBooking.getRooms().stream()
                    .filter(r -> r.isAvailable() && r.getType().equalsIgnoreCase(newRoomType))
                    .findFirst()
                    .orElse(null);

            if (newRoom != null) {
                // Actualizar la reserva
                newRoom.setAvailable(false);
                room.setAvailable(true); // Liberar la habitación anterior
                ticketToUpdate.setRoom(newRoom);
                System.out.println("¡La reserva ha sido actualizada con éxito!");
                System.out.println("Nueva habitación: " + newRoom.getType() + " - $" + newRoom.getPrice());
            } else {
                System.out.println("No se encontró una habitación disponible del tipo solicitado.");
            }
        } else if (response.equalsIgnoreCase("Hotel")) {
            System.out.println("No.");
        } else {
            System.out.println("No se realizó ningún cambio en la reserva.");
        }
    }
    /*
    private Room findAvailableRoom(String roomType) {
        for (AccomodationBase accommodation : accommodations) {
            if (accommodation instanceof Hotel) {
                Hotel hotel = (Hotel) accommodation;
                for (Room room : hotel.getRooms()) {
                    if (room.isAvailable() && room.getType().equalsIgnoreCase(roomType)) {
                        return room;
                    }
                }
            }
        }
        return null;
    }*/

}