package com.akshit;



import com.akshit.gate.EntranceGate;
import com.akshit.parkingspot.ParkingSpot;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;

public class ParkingSpotStrategy {

    Map<String, PriorityBlockingQueue<ParkingSpot>> gateToSpotsMap;

    Map<String, ParkingSpot> reservedSpotIdToParkingSpotMap;

    Map<String, ParkingSpot> freeSpotIdToParkingSpotMap;

    List<ParkingSpot> parkingSpotList;

    public ParkingSpotStrategy(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
        freeSpotIdToParkingSpotMap = new ConcurrentHashMap<>();
        for (ParkingSpot spot: parkingSpotList) {
            freeSpotIdToParkingSpotMap.put(spot.getId(), spot);
        }
        reservedSpotIdToParkingSpotMap = new ConcurrentHashMap<>();
        gateToSpotsMap = new ConcurrentHashMap<>();
    }

    public synchronized void addEntrance(EntranceGate gate) {
        String gateId = gate.getGateId();
        if (gateToSpotsMap.containsKey(gateId)) {
            return;
        }
        PriorityBlockingQueue<ParkingSpot> queue = generateDistanceQueue(gate.getLocation(), parkingSpotList);
        gateToSpotsMap.put(gateId, queue);
    }

    public synchronized ParkingSpot getParkingSpot(EntranceGate gate) {
        String gateId = gate.getGateId();
        if (!gateToSpotsMap.containsKey(gateId)) {
            throw new IllegalArgumentException("Gate not registered");
        }
        PriorityBlockingQueue<ParkingSpot> queue = gateToSpotsMap.get(gateId);
        System.out.println("Available space: " + freeSpotIdToParkingSpotMap.size());

        if (freeSpotIdToParkingSpotMap.values().size() == 0) {
            throw new IllegalArgumentException("No more space in parking lot.");
        }
        ParkingSpot spot = queue.poll();
        reservedSpotIdToParkingSpotMap.put(spot.getId(), spot);
        freeSpotIdToParkingSpotMap.remove(spot.getId());
        for (PriorityBlockingQueue q: gateToSpotsMap.values()) {
            q.remove(spot);
        }
        return spot;
    }

    public synchronized ParkingSpot getParkingSpot(String parkingSpotId) {
        return reservedSpotIdToParkingSpotMap.get(parkingSpotId);
    }

    public synchronized void freeParkingSpot(ParkingTicket ticket) {
        ParkingSpot spot = reservedSpotIdToParkingSpotMap.get(ticket.parkingSpotId);
        spot.setVehicle(null);
        // check if null else throw
        PriorityBlockingQueue<ParkingSpot> queue = gateToSpotsMap.get(ticket.getEntranceGateId());
        queue.add(spot);
        reservedSpotIdToParkingSpotMap.remove(ticket.parkingSpotId);
        freeSpotIdToParkingSpotMap.put(ticket.parkingSpotId, spot);
    }

    private PriorityBlockingQueue<ParkingSpot> generateDistanceQueue(Location gateLocation, List<ParkingSpot> parkingSpotList) {
        PriorityBlockingQueue<ParkingSpot> queue = new PriorityBlockingQueue<>(1, new Comparator<ParkingSpot>() {
            @Override
            public int compare(ParkingSpot o1, ParkingSpot o2) {
                return (int) (Location.calcDistance(gateLocation, o2.getLocation()) - Location.calcDistance(gateLocation, o1.getLocation()));
            }
        });
        queue.addAll(parkingSpotList);
        return queue;
    }
}
