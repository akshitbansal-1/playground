package com.akshit.gate;

import com.akshit.*;
import com.akshit.parkingspot.ParkingSpot;

import java.util.Date;

public class EntranceGate extends Thread {
    String id;

    Location location;

    ParkingSpotStrategy parkingSpotStrategy;

    public EntranceGate(String id, Location location, ParkingSpotStrategy strategy) {
        this.id = id;
        this.location = location;
        parkingSpotStrategy = strategy;
    }

    public ParkingTicket getTicket(Vehicle vehicle) {
        ParkingSpot spot = parkingSpotStrategy.getParkingSpot(this);
        spot.setVehicle(vehicle);
        return new ParkingTicket(
                "uuid",
                vehicle,
                new Date().getTime(),
                spot.getId(),
                this.id
        );

    }

    public String getGateId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public void run() {

    }
}
