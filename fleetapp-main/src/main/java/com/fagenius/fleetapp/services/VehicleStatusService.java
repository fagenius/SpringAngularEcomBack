package com.fagenius.fleetapp.services;

import com.fagenius.fleetapp.models.Location;
import com.fagenius.fleetapp.models.VehicleStatus;
import com.fagenius.fleetapp.repositories.LocationRepository;
import com.fagenius.fleetapp.repositories.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService {
    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;
    public List<VehicleStatus> findAll() {
        return (List<VehicleStatus>) vehicleStatusRepository.findAll();
    }

    public Optional<VehicleStatus> findById(Integer id) {
        return vehicleStatusRepository.findById(id);
    }

    public void save(VehicleStatus vehicleStatus) {
        vehicleStatusRepository.save(vehicleStatus);
    }

    public void deleteById(Integer id) {
        vehicleStatusRepository.deleteById(id);
    }

    public List<VehicleStatus> findByDescriptionContaining(String description) {
        return null;
    }
}
