package com.fagenius.fleetapp.services;

import com.fagenius.fleetapp.models.Vehicle;
import com.fagenius.fleetapp.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public void deleteById(Integer id) {
        vehicleRepository.deleteById(id);
    }

    public void save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    public Optional<Vehicle> findById(Integer id) {
        return vehicleRepository.findById(id);
    }
}
