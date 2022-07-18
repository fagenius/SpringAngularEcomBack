package com.fagenius.fleetapp.services;

import com.fagenius.fleetapp.models.Location;
import com.fagenius.fleetapp.models.VehicleMaintenance;
import com.fagenius.fleetapp.repositories.LocationRepository;
import com.fagenius.fleetapp.repositories.VehicleMaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMaintenanceService {
    @Autowired
    private VehicleMaintenanceRepository vehicleMaintenanceRepository;

    public List<VehicleMaintenance> findAll() {
        return vehicleMaintenanceRepository.findAll();
    }

    public Optional<VehicleMaintenance> findById(Integer id) {
        return vehicleMaintenanceRepository.findById(id);
    }

    public void save(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceRepository.save(vehicleMaintenance);
    }

    public void deleteById(Integer id) {
        vehicleMaintenanceRepository.deleteById(id);
    }

}
