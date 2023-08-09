package com.akshit;

public class ParkingTicket {

    String id;
    Vehicle vehicleInfo;

    long issueTime;

    String parkingSpotId;

    String entranceGateId;

    public ParkingTicket(String id, Vehicle vehicleInfo, long issueTime, String parkingSpotId, String entranceGateId) {
        this.id = id;
        this.vehicleInfo = vehicleInfo;
        this.issueTime = issueTime;
        this.parkingSpotId = parkingSpotId;
        this.entranceGateId = entranceGateId;
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicleInfo() {
        return vehicleInfo;
    }

    public long getIssueTime() {
        return issueTime;
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }

    public String getEntranceGateId() {
        return entranceGateId;
    }
}
