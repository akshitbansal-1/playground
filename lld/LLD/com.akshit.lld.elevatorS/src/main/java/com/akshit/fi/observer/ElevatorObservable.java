package com.akshit.fi.observer;

import com.akshit.common.Observable;
import com.akshit.fi.Elevator;
import com.akshit.fi.panel.ElevatorPanel;

import java.util.*;

public class ElevatorObservable implements Observable<ElevatorPanel, Elevator> {

    Map<String, Set<ElevatorPanel>> elevatorPanels;

    ElevatorObservable(List<Elevator> elevatorPanels) {
        this.elevatorPanels = new HashMap<>();
    }

    @Override
    public void add(ElevatorPanel elevatorPanel) {
        Set<ElevatorPanel> elevatorPanelList = elevatorPanels.getOrDefault(elevatorPanel.getElevatorId(), new HashSet<>());
        elevatorPanelList.add(elevatorPanel);
    }

    @Override
    public void remove(ElevatorPanel elevatorPanel) {
        Set<ElevatorPanel> elevatorPanelList = elevatorPanels.get(elevatorPanel.getElevatorId());
        elevatorPanelList.remove(elevatorPanel);
    }

    @Override
    public void setData(Elevator ele) {
        String elevatorId = ele.getElevatorId();
        int currentFloor = ele.getCurrentFloor();
        for (ElevatorPanel elevatorPanel: elevatorPanels.getOrDefault(elevatorId, new HashSet<>())) {
            elevatorPanel.updateDisplayScreen(Integer.toString(currentFloor));
        }
    }

}
