package com.akshit.parkingspot;

import com.akshit.Location;
import com.akshit.Vehicle;

public abstract class ParkingSpot {

    String id;
    Location location;

    String type;

    double perSecondTariff;

    boolean reserved;

    Vehicle vehicle;

    public ParkingSpot(String id, Location location, String type, double perSecondTariff) {
        this.id = id;
        this.location = location;
        this.type = type;
        this.perSecondTariff = perSecondTariff;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    public String getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public abstract double getTariff(long timeSpent);

    public String getType() {
        return type;
    }

    public double getPerSecondTariff() {
        return perSecondTariff;
    }
}
