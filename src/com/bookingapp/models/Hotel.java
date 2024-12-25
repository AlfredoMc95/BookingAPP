package com.bookingapp.models;

import java.util.List;

public class Hotel extends AccomodationBase {
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
    public double totalPriceSum(int quantityOfRooms, int checkIn){
        Room room = getLowerPriceRoom();
        double totalPrice = getPricePerNight() * quantityOfRooms * room.getPrice();
        double discount = totalPriceDiscount(checkIn);
        totalPrice = totalPrice + discount;
        return totalPrice;
    }

    // busaca el cuarto mas barato y que este "valido" non este en uso ...
    public Room getLowerPriceRoom(){
        Room cheapestRoom = null;
        double lowestPrice = Double.MAX_VALUE;

        for (Room room : rooms) {
            if (room.isAvailable() && room.getPrice() < lowestPrice) {
                lowestPrice = room.getPrice();
                cheapestRoom = room;
            }
        }

        return cheapestRoom;
    }

    public void showRooms() {
        long availableRooms = rooms.stream().filter(Room::isAvailable).count();
        System.out.println("curtos disponibles: " + availableRooms);
        for (Room room: rooms){
            if(room.isAvailable()){
                System.out.println("- typo: "+ room.getType() +". - descirpcion: "+room.getDescription()+". - Precio base: "+room.getPrice());
            }
        }
        System.out.println("------------------------");
    }

}
