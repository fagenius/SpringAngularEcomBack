package com.fagenius.fleetapp.services;

import com.fagenius.fleetapp.models.Location;
import com.fagenius.fleetapp.models.Vehicle;
import com.fagenius.fleetapp.models.VehicleMake;
import com.fagenius.fleetapp.repositories.LocationRepository;
import com.fagenius.fleetapp.repositories.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeService {
    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;
    public List<VehicleMake> findAll() {
        return (List<VehicleMake>) vehicleMakeRepository.findAll();
    }

    public Optional<VehicleMake> findById(Integer id) {
        return vehicleMakeRepository.findById(id);
    }

    public void save(VehicleMake vehicleMake) {
        vehicleMakeRepository.save(vehicleMake);
    }

    public void deleteById(Integer id) {
        vehicleMakeRepository.deleteById(id);
    }

    public List<VehicleMake> findByDescriptionContaining(String description) {
        return null;
    }
}
