package com.bookingapp.utilities;

import com.bookingapp.models.AccommodationBase;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HotelMapPanel extends JPanel {
    private final List<HotelDrawInfo> hotels = new ArrayList<>();

    public void addHotel(AccommodationBase hotel, int x, int y) {
        hotels.add(new HotelDrawInfo(hotel, x, y));
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (HotelDrawInfo hotelInfo : hotels) {
            hotelInfo.hotel.draw(g, hotelInfo.x, hotelInfo.y);
        }
    }

    private static class HotelDrawInfo {
        AccommodationBase hotel;
        int x, y;
        int pricePerNight;

        public HotelDrawInfo(AccommodationBase hotel, int x, int y) {
            this.hotel = hotel;
            this.x = x;
            this.y = y;
        }
    }
}
