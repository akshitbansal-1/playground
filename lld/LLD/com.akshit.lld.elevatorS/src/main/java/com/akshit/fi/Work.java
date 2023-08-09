package com.akshit.fi;

public class Work implements Comparable<Work> {
    int currentFloor;

    int desiredFloor;

    Direction direction;

    Location location;

    public Work(int currentFloor, int desiredFloor, Direction direction, Location location) {
        this.currentFloor = currentFloor;
        this.desiredFloor = desiredFloor;
        this.direction = direction;
        this.location = location;
    }

    @Override
    public int compareTo(Work o) {
        return this.desiredFloor - o.desiredFloor;
    }
}
