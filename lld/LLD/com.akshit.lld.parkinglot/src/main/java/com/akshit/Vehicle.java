package com.akshit;

public class Vehicle {
    String registrationNumber;

    String model; // optional

    String vehicleType;

    public Vehicle(String registrationNumber, String model, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
