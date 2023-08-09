package com.akshit;

import com.akshit.gate.EntranceGate;
import com.akshit.gate.ExitGate;
import com.akshit.parkingspot.LuxuryParkingSpot;
import com.akshit.parkingspot.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ParkingSpot p1 = new LuxuryParkingSpot("1", new Location(1, "1"));
        ParkingSpot p2 = new LuxuryParkingSpot("2", new Location(1, "2"));
        ParkingSpot p3 = new LuxuryParkingSpot("3", new Location(1, "3"));
        List<ParkingSpot> parkingSpotList = new ArrayList<>();
        parkingSpotList.add(p1);
        parkingSpotList.add(p2);
        parkingSpotList.add(p3);
        PaymentMethod method1 = new PaymentMethod();
        List<PaymentMethod> paymentMethodList = new ArrayList<>();

        ParkingSpotStrategy strategy = new ParkingSpotStrategy(parkingSpotList);

        EntranceGate entranceGate = new EntranceGate("en1", new Location(1, "en1"), strategy);
        EntranceGate entranceGate2 = new EntranceGate("en2", new Location(1, "en2"), strategy);
        entranceGate2.start();
        entranceGate.start();
        ExitGate exitGate = new ExitGate("ex1", new Location(1, "ex1"), strategy, paymentMethodList);
        List<EntranceGate> entranceGates = new ArrayList<>();
        List<ExitGate> exitGates = new ArrayList<>();
        entranceGates.add(entranceGate);
        entranceGates.add(entranceGate2);
        exitGates.add(exitGate);


        ParkingLot lot = new ParkingLot(parkingSpotList, entranceGates, exitGates, new Logger(), strategy);

        ParkingTicket t1 = parkVehicle(lot, entranceGate, "1");
        ParkingTicket t3 = parkVehicle(lot, entranceGate, "3");

        Thread.sleep(1000);
//        getCost(lot, t1, exitGate);
//        lot.payTariff(t1, new PaymentMethod(), exitGate);

        ParkingTicket t2 = parkVehicle(lot, entranceGate2, "2");
        Thread.sleep(1000);
//        getCost(lot, t2, exitGate);
//        lot.payTariff(t2, new PaymentMethod(), exitGate);

        Thread.sleep(1000);
//        getCost(lot, t3, exitGate);

        ParkingTicket t4 = parkVehicle(lot, entranceGate, "4");
        Thread.sleep(1000);
        lot.payTariff(t3, new PaymentMethod(), exitGate);
        t4 = parkVehicle(lot, entranceGate2, "4");
        getCost(lot, t4, exitGate);
        lot.payTariff(t4, new PaymentMethod(), exitGate);
    }

    private static void getCost(ParkingLot lot, ParkingTicket ticket, ExitGate gate) {
        if (ticket != null) {
            System.out.println("Cost of parking for " + ticket.vehicleInfo.registrationNumber + " is: " + lot.calcTariff(ticket, gate));
        }
    }

    private static ParkingTicket parkVehicle(ParkingLot lot, EntranceGate gate, String id) {
        Vehicle v = new Vehicle(id, "123", "");
        try {
            return lot.parkVehicle(v, gate);
        } catch (Exception e) {
            System.out.println("No more cap for " + v.registrationNumber);
            return null;
        }
    }
}
