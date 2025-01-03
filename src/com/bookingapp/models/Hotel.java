package com.bookingapp.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.bookingapp.utilities.PrintMessage.printSeparator;

public class Hotel extends AccommodationBase {
    private List<Room> rooms;
    private List<BookingTicket> bookingTickets;

    public Hotel(String name, int rate, double pricePerNight, String city, List<Room> rooms) {
        super(name, rate, city, pricePerNight);
        this.rooms = rooms != null ? rooms : new ArrayList<>();
        this.bookingTickets = new ArrayList<>();
    }

    public Hotel() {
        this.rooms = new ArrayList<>();
        this.bookingTickets = new ArrayList<>();
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<BookingTicket> getBookingTickets() {
        return bookingTickets;
    }

    public void addBookingTicket(BookingTicket bookingTicket) {
        if (bookingTicket != null) {
            this.bookingTickets.add(bookingTicket);
        }
    }

    @Override
    public double calculateTotalPrice(int quantityOfRooms, LocalDate checkIn){
        Room room = findCheapestRoom();
        double totalPrice = getPricePerNight() * quantityOfRooms * room.getPrice();
        double discount = totalPriceDiscount(checkIn);
        totalPrice = totalPrice + discount;
        return totalPrice;
    }

    public double totalPriceDiscount(LocalDate checkIn) {
        int checkInDay = checkIn.getDayOfMonth();
        double discount = calculateDiscount(checkInDay);
        return this.getPricePerNight() * discount;
    }

    private double calculateDiscount(int checkInDay) {
        if (isEndOfMonth(checkInDay, checkInDay)) {
            return 0.15;
        }
        if (isWithinRange(checkInDay, 10, 15)) {
            return 0.10;
        }
        if (isWithinRange(checkInDay, 5, 9)) {
            return -0.08;
        }
        return 0;
    }

    private boolean isEndOfMonth(int checkInDay, int lengthOfMonth) {
        return checkInDay > (lengthOfMonth - 5);
    }

    private boolean isWithinRange(int checkInDay, int start, int end) {
        return checkInDay >= start && checkInDay <= end;
    }

    public Room findCheapestRoom() {
        return rooms.stream()
                .filter(Room::isAvailable)
                .min(Comparator.comparingDouble(Room::getPrice))
                .orElse(null);
    }

    public void displayAvailableRooms() {
        long availableRooms = rooms.stream().filter(Room::isAvailable).count();
        System.out.println("Cuartos disponibles: " + availableRooms);

        rooms.stream()
                .filter(Room::isAvailable)
                .forEach(room -> System.out.println("- Tipo: " + room.getType() +
                        ". Descripción: " + room.getDescription() +
                        ". Precio base: " + room.getPrice()));

        printSeparator();
    }

    // verifica todos lso cuartos libres
    public boolean hasAvailableRooms(int quantity) {
        long availableRoomCount = rooms.stream().filter(Room::isAvailable).count();
        return availableRoomCount >= quantity;
    }

}
