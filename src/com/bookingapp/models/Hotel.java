package com.bookingapp.models;

import java.util.Comparator;
import java.util.List;

import static com.bookingapp.utilities.PrintMessage.printSeparator;

public class Hotel extends AccommodationBase {
    private List<Room> rooms;

    public Hotel(String name, int rate, double pricePerNight, String city, List<Room> rooms) {
        super(name,rate,city,pricePerNight);
        this.rooms = rooms;
    }

    public Hotel() {
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public double calculateTotalPrice(int quantityOfRooms, int checkIn){
        Room room = findCheapestRoom();
        double totalPrice = getPricePerNight() * quantityOfRooms * room.getPrice();
        double discount = totalPriceDiscount(checkIn);
        totalPrice = totalPrice + discount;
        return totalPrice;
    }

    public Room findCheapestRoom(){
        return rooms.stream()
                .filter(Room::isAvailable)
                .min(Comparator.comparingDouble(Room::getPrice))
                .orElse(null);
    }

    public void displayAvailableRooms() {
        long availableRooms = rooms.stream().filter(Room::isAvailable).count();
        System.out.println("cuartos disponibles: " + availableRooms);
        for (Room room: rooms){
            if(room.isAvailable()){
                System.out.println("- typo: "+ room.getType() +". - descripción: "+room.getDescription()+". - Precio base: "+room.getPrice());
            }
        }
        printSeparator();
    }

}
