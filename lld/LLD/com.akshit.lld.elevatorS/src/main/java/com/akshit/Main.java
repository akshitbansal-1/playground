package com.akshit;

import com.akshit.fi.Direction;
import com.akshit.fi.Elevator;
import com.akshit.fi.Scheduler;
import com.akshit.fi.State;
import com.akshit.fi.elevatorbutton.ElevatorButton;
import com.akshit.fi.elevatorbutton.FloorButton;
import com.akshit.fi.elevatorbutton.HallButton;
import com.akshit.fi.observer.ButtonObserver;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Elevator elevator = new Elevator(0, Direction.UP, State.IDLE, "1");
        Elevator elevator2 = new Elevator(0, Direction.UP, State.IDLE, "2");

        List<Elevator> elevatorList = new ArrayList<>();
        elevatorList.add(elevator);
        elevatorList.add(elevator2);
        Scheduler scheduler = new Scheduler(elevatorList);

        ButtonObserver buttonObserver = new ButtonObserver(scheduler);

        ElevatorButton button1 = new HallButton("HB1", buttonObserver);
        ElevatorButton button2 = new HallButton("HB2", buttonObserver);

        ElevatorButton button3 = new FloorButton("FB1", buttonObserver);
        ElevatorButton button4 = new FloorButton("FB2", buttonObserver);

        for (Elevator elv: elevatorList) {
            elv.start();
        }
        System.out.println("Started all elevators");

        button1.pressButton(1, 1, Direction.UP);
        button3.pressButton(1, 2, Direction.UP);
        button2.pressButton(2, 2, Direction.UP);
        button1.pressButton(2, 2, Direction.DOWN);
        button3.pressButton(2, 0, Direction.DOWN);
        button4.pressButton(2, 4, Direction.UP);

    }
}
