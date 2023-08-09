package com.akshit.fi;

import java.util.List;

public class Scheduler {
    List<Elevator> elevators;

    public Scheduler(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    public void updateWork(Work work) {
        Elevator elevator = getBestElevator(work);
        if (work.direction == Direction.UP) {
            elevator.addUpRequest(work);
        } else {
            elevator.addDownRequest(work);
        }
    }

    private Elevator getBestElevator(Work work) {
        // have a strategy between elevators
        int randomIndex = (int) (Math.random() * elevators.size());
        return elevators.get(randomIndex);
    }
}
