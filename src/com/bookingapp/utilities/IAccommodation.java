package com.bookingapp.utilities;

import com.bookingapp.models.Room;

import java.util.Date;
import java.util.List;

public interface IAccommodation {

    List<Room> checkAvailability(Date checkIn, Date checkOut , int quantityOfRooms);
    double calculatePrice(int quantityOfRooms,Date checkIn, Date checkOut );
}
