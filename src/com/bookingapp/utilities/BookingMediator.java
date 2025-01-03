package com.bookingapp.utilities;

import com.bookingapp.models.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static com.bookingapp.controllers.UpdateHotel.updateHotel;
import static com.bookingapp.controllers.UpdateRoom.updateRoom;
import static com.bookingapp.utilities.PrintMessage.*;
import static com.bookingapp.views.BookingDataView.bookingDataView;

public class BookingMediator implements Mediator {
    private static BookingMediator instance;

    private BookingMediator() {
    }

    public static BookingMediator getInstance() {
        if (instance == null) {
            instance = new BookingMediator();
        }
        return instance;
    }

    @Override
    public List<AccommodationBase> findAccommodations(String city, String type, LocalDate checkIn, LocalDate checkOut, int adults, int children, int rooms) {
        return AccommodationFactory.getAllAccommodations().stream()
                .filter(accommodation -> accommodation.getCity().equalsIgnoreCase(city))
                .filter(accommodation -> matchesTypeAndAvailability(accommodation, type, rooms))
                .toList();
    }

    private boolean matchesTypeAndAvailability(AccommodationBase accommodation, String type, int rooms) {
        return switch (type.toLowerCase()) {
            case "hotel" -> accommodation instanceof Hotel hotel && hotel.hasAvailableRooms(rooms);
            case "apartamento" -> accommodation instanceof Apartment;
            case "finca" -> accommodation instanceof Estate;
            case "dia de sol" -> accommodation instanceof DayOfSun;
            default -> false;
        };
    }

    @Override
    public BookingTicket findBookingTicket(String email, String birthdate) {
        return AccommodationFactory.getAllAccommodations().stream()
                .filter(Hotel.class::isInstance)
                .map(Hotel.class::cast)
                .flatMap(hotel -> hotel.getBookingTickets().stream())
                .filter(ticket -> ticket.getUser().getEmail().equalsIgnoreCase(email) &&
                        ticket.getUser().getBirthdate().equalsIgnoreCase(birthdate))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Hotel findHotelWithBooking(BookingTicket ticketToUpdate) {
        return AccommodationFactory.getAllAccommodations().stream()
                .filter(Hotel.class::isInstance)
                .map(Hotel.class::cast)
                .filter(hotel -> hotel.getBookingTickets().contains(ticketToUpdate))
                .findFirst()
                .orElse(null);
    }

    public static List<AccommodationBase> findAccommodationsByName(String name, int rooms) {
        return AccommodationFactory.getAllAccommodations().stream()
                .filter(accommodation -> accommodation.getName().equalsIgnoreCase(name))
                .filter(accommodation -> {
                    if (accommodation instanceof Hotel hotel) {
                        return hotel.hasAvailableRooms(rooms);
                    }
                    return true;
                })
                .toList();
    }

    @Override
    public void showRooms(String hotelName,LocalDate checkIn, LocalDate checkOut, int adults, int children, int rooms) {
        List<AccommodationBase> results = findAccommodationsByName(hotelName, rooms);

        if (results.isEmpty()) {
            printNotFound();
        } else {
            for (AccommodationBase result : results) {
                if (result instanceof Hotel hotel) {
                    hotel.displayAvailableRooms();
                }
            }
        }
    }

    @Override
    public void updateBooking(String email, String birthdate) {
        BookingTicket ticketToUpdate = findBookingTicket(email, birthdate);

        if (ticketToUpdate == null) {
            printNotFound();
            printSeparator();
            return;
        }

        Hotel hotelWithBooking = findHotelWithBooking(ticketToUpdate);

        bookingDataView(hotelWithBooking, ticketToUpdate);
        handleBookingUpdate(ticketToUpdate, hotelWithBooking);
    }

    private static void handleBookingUpdate(BookingTicket ticketToUpdate, Hotel hotelWithBooking) {
        Scanner scanner = new Scanner(System.in);
        printStrigMessage("¿Qué desea actualizar? (Room / Hotel): ");
        String response = scanner.nextLine().trim();

        switch (response.toLowerCase()) {
            case "room" -> updateRoom(ticketToUpdate, hotelWithBooking);
            case "hotel" -> updateHotel(ticketToUpdate, hotelWithBooking);
            default -> printStrigMessage("No se realizó ningún cambio en la reserva.");
        }
    }

    private void printNotFound() {
        printNotFound();
    }
}
