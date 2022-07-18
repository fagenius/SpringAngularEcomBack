package com.fagenius.fleetapp.services;

import com.fagenius.fleetapp.models.Location;
import com.fagenius.fleetapp.models.VehicleHire;
import com.fagenius.fleetapp.repositories.LocationRepository;
import com.fagenius.fleetapp.repositories.VehicleHireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleHireService {
    @Autowired
    private VehicleHireRepository vehicleHireRepository;
    public List<VehicleHire> findAll() {
        return (List<VehicleHire>) vehicleHireRepository.findAll();
    }

    public Optional<VehicleHire> findById(Integer id) {
        return vehicleHireRepository.findById(id);
    }

    public void save(VehicleHire vehicleHire) {
        vehicleHireRepository.save(vehicleHire);
    }

    public void deleteById(Integer id) {
        vehicleHireRepository.deleteById(id);
    }

    public List<Location> findByDescriptionContaining(String description) {
        return null;
    }
}
