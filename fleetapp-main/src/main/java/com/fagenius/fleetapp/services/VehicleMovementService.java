package com.fagenius.fleetapp.services;

import com.fagenius.fleetapp.models.State;
import com.fagenius.fleetapp.models.VehicleMovement;
import com.fagenius.fleetapp.repositories.StateRepository;
import com.fagenius.fleetapp.repositories.VehicleMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMovementService {
    @Autowired
    private VehicleMovementRepository vehicleMovementRepository;

    //Get All States
    public List<VehicleMovement> findAll(){
        return vehicleMovementRepository.findAll();
    }

    //Get State By Id
    public Optional<VehicleMovement> findById(int id) {
        return vehicleMovementRepository.findById(id);
    }

    //Delete State
    public void delete(int id) {
        vehicleMovementRepository.deleteById(id);
    }

    //Update State
    public void save( VehicleMovement vehicleMovement) {
        vehicleMovementRepository.save(vehicleMovement);
    }
}
