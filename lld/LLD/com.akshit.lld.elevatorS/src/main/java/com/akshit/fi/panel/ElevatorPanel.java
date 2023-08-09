package com.akshit.fi.panel;

import com.akshit.fi.elevatorbutton.ElevatorButton;

import java.util.List;

public abstract class ElevatorPanel {

    String displayScreen;

    List<ElevatorButton> buttons;

    String elevatorId;

    public ElevatorPanel(List<ElevatorButton> buttons, String elevatorId) {
        // assert floor
        this.buttons = buttons;
        this.elevatorId = elevatorId;
    }

    public String getElevatorId() {
        return elevatorId;
    }

    public void updateDisplayScreen(String displayScreen) {
        System.out.println("Updating screen: " + displayScreen);
        this.displayScreen = displayScreen;
    }


}
