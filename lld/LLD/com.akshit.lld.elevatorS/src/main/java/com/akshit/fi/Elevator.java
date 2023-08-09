package com.akshit.fi;

import java.util.Collections;
import java.util.PriorityQueue;

public class Elevator extends Thread {

    int currentFloor;

    Direction direction;

    String id;

    com.akshit.fi.State state;

    PriorityQueue<Work> upRequests, downRequests;

    public Elevator(int currentFloor, Direction direction, com.akshit.fi.State state, String id) {
        this.currentFloor = currentFloor;
        this.direction = direction;
        this.state = state;
        upRequests = new PriorityQueue<>();
        downRequests = new PriorityQueue<>(Collections.reverseOrder());
        this.id = id;
    }

    public void addUpRequest(Work work) {
        upRequests.add(work);

    }

    public void run() {
        while (true) {
            if (!checkJob()) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if (direction == Direction.UP || state == com.akshit.fi.State.IDLE) {
                processUpRequests();
                processDownRequests();
            } else {
                processDownRequests();
                processUpRequests();
            }

            state = com.akshit.fi.State.IDLE;
        }
    }

    private void processUpRequests() {
        state = com.akshit.fi.State.MOVING;
        direction = Direction.UP;
        while (!upRequests.isEmpty()) {
            Work work = upRequests.poll();
            assert work != null;
            if (work.location == Location.INSIDE_ELEVATOR) {
                System.out.println("EV " + id + ", moving from: " + currentFloor + " to " + work.desiredFloor);
            } else {
                System.out.println("EV " + id + ", current floor: " + currentFloor + " ,picking from: " + work.desiredFloor);
            }
            currentFloor = work.desiredFloor;
        }
    }

    private void processDownRequests() {
        state = com.akshit.fi.State.MOVING;
        direction = Direction.DOWN;
        while (!downRequests.isEmpty()) {
            Work work = downRequests.poll();
            assert work != null;
            if (work.desiredFloor != work.currentFloor) {
                System.out.println("EV " + id + ", moving from: " + currentFloor + " to " + work.desiredFloor);
            } else {
                System.out.println("EV " + id + ", current floor: " + currentFloor + " ,picking from: " + work.desiredFloor);
            }
            currentFloor = work.desiredFloor;
        }
    }

    private boolean checkJob() {
        return !upRequests.isEmpty() || downRequests.isEmpty();
    }

    public void addDownRequest(Work work) {
        downRequests.add(work);
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public String getElevatorId() {
        return id;
    }
}
