package com.fagenius.fleetapp.services;

import com.fagenius.fleetapp.models.Location;
import com.fagenius.fleetapp.models.Vehicle;
import com.fagenius.fleetapp.models.VehicleType;
import com.fagenius.fleetapp.repositories.LocationRepository;
import com.fagenius.fleetapp.repositories.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeService {
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;
    public List<VehicleType> findAll() {
        return (List<VehicleType>) vehicleTypeRepository.findAll();
    }

    public Optional<VehicleType> findById(Integer id) {
        return vehicleTypeRepository.findById(id);
    }

    public void save(VehicleType vehicleType) {
        vehicleTypeRepository.save(vehicleType);
    }

    public void deleteById(Integer id) {
        vehicleTypeRepository.deleteById(id);
    }

    public List<VehicleType> findByDescriptionContaining(String description) {
        return null;
    }
}
