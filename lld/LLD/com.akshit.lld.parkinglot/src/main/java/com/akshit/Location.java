package com.akshit;

public class Location {

    int floorId;

    String slot;

    public Location(int floorId, String slot) {
        this.floorId = floorId;
        this.slot = slot;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }


    public static double calcDistance(Location l1, Location l2) {
        return l1.floorId - l2.floorId;
    }
}
