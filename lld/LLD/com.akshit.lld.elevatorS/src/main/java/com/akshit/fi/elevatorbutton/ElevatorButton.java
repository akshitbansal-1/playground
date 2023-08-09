package com.akshit.fi.elevatorbutton;

import com.akshit.fi.Direction;

public abstract class ElevatorButton {
    String buttonName;

    public ElevatorButton(String buttonName) {
        this.buttonName = buttonName;
    }

    public abstract void pressButton(int currentFloor, int desiredFloor, Direction direction);
}
