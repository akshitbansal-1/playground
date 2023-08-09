package com.akshit.parkingspot;

import com.akshit.Location;

public class LuxuryParkingSpot extends ParkingSpot {

    public LuxuryParkingSpot(String id, Location location) {
        super(id, location, "Luxury", 100);
    }

    @Override
    public double getTariff(long timeSpent) {
        return timeSpent * getPerSecondTariff() / 1000;
    }
}
