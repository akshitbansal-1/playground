package com.akshit;

import com.akshit.gate.EntranceGate;
import com.akshit.gate.ExitGate;
import com.akshit.parkingspot.ParkingSpot;

import java.util.List;

public class ParkingLot {

    List<ParkingSpot> parkingSpotList;
    List<EntranceGate> entranceGates;
    List<ExitGate> exitGates;
    Logger logger;
    ParkingSpotStrategy strategy;

    public ParkingLot(List<ParkingSpot> parkingSpotList, List<EntranceGate> entranceGates, List<ExitGate> exitGates, Logger logger, ParkingSpotStrategy strategy) {
        this.parkingSpotList = parkingSpotList;
        this.entranceGates = entranceGates;
        this.exitGates = exitGates;
        this.logger = logger;
        for (EntranceGate gate: entranceGates) {
            strategy.addEntrance(gate);
        }
        this.strategy = strategy;
    }

    public ParkingTicket parkVehicle(Vehicle vehicle, EntranceGate gate) {
        try {
            logger.logEvent("Parked vehicle " + vehicle.registrationNumber);
            return gate.getTicket(vehicle);
        } catch (Exception e) {
            // tell customer
            throw e;
        }
    }

    public double calcTariff(ParkingTicket ticket, ExitGate exitGate) {
        return exitGate.calcTariff(ticket);
    }

    public void payTariff(ParkingTicket ticket, PaymentMethod method, ExitGate exitGate) {
        if (ticket == null) {
            return;
        }
        try {
            logger.logEvent("Paid for vehicle " + ticket.vehicleInfo.registrationNumber);
            method.pay();
            exitGate.freeParkingSlot(ticket);
        } catch (Exception e) {
            // tell customer
        }
    }
}
