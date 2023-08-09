package com.akshit.gate;

import com.akshit.Location;
import com.akshit.PaymentMethod;
import com.akshit.parkingspot.ParkingSpot;
import com.akshit.ParkingSpotStrategy;
import com.akshit.ParkingTicket;

import java.util.Date;
import java.util.List;

public class ExitGate {

    String id;

    Location location;

    ParkingSpotStrategy parkingSpotStrategy;

    List<PaymentMethod> paymentMethodList;

    public ExitGate(String id, Location location, ParkingSpotStrategy strategy, List<PaymentMethod> paymentMethodList) {
        this.id = id;
        this.location = location;
        parkingSpotStrategy = strategy;
        this.paymentMethodList = paymentMethodList;
    }

    public void freeParkingSlot(ParkingTicket ticket) {
        parkingSpotStrategy.freeParkingSpot(ticket);
    }

    public double calcTariff(ParkingTicket ticket) {
        ParkingSpot spot = parkingSpotStrategy.getParkingSpot(ticket.getParkingSpotId());
        return spot.getTariff((new Date().getTime() - ticket.getIssueTime())/1000);
    }

}
