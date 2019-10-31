package com.example.carrental;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepositry {
    private static VehicleRepositry instance;
    private Map<String, Vehicle> vehicles = new HashMap<>();

    private VehicleRepositry(){}

    public static VehicleRepositry getInstance(){
        if(instance == null){
            instance = new VehicleRepositry();
        }
        return instance;
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.put(vehicle.licencePlate.toLowerCase(), vehicle);
    }

    public Map<String, Vehicle> getVehicles(){
        return vehicles;
    }

    public void removeVehicle(String license){
        instance.vehicles.remove(license.toLowerCase());
    }
}
