package com.akshit.fi.elevatorbutton;

import com.akshit.fi.Location;
import com.akshit.fi.Direction;
import com.akshit.fi.Work;
import com.akshit.fi.observer.ButtonObserver;

public class HallButton extends ElevatorButton {

    ButtonObserver buttonObserver;

    public HallButton(String buttonName, ButtonObserver buttonObserver) {
        super(buttonName);
        this.buttonObserver = buttonObserver;
    }

    @Override
    public void pressButton(int currentFloor, int desiredFloor, Direction direction) {
        System.out.println("Pressed HB: " + buttonName);
        Work work = new Work(currentFloor, desiredFloor, direction, Location.OUTSIDE_ELEVATOR);
        buttonObserver.update(work);
    }
}
