package com.akshit.fi.panel;

import com.akshit.fi.elevatorbutton.ElevatorButton;

import java.util.List;

public class HallElevatorPanel extends ElevatorPanel {

    int currentFloor;

    public HallElevatorPanel(List<ElevatorButton> buttons, String elevatorId, int currentFloor) {
        super(buttons, elevatorId);
        this.currentFloor = currentFloor;
    }

}
