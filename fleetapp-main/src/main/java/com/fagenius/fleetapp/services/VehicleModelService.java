package com.fagenius.fleetapp.services;

import com.fagenius.fleetapp.models.Location;
import com.fagenius.fleetapp.models.Vehicle;
import com.fagenius.fleetapp.models.VehicleModel;
import com.fagenius.fleetapp.repositories.LocationRepository;
import com.fagenius.fleetapp.repositories.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {
    @Autowired
    private VehicleModelRepository vehicleModelRepository;
    public List<VehicleModel> findAll() {
        return (List<VehicleModel>) vehicleModelRepository.findAll();
    }

    public Optional<VehicleModel> findById(Integer id) {
        return vehicleModelRepository.findById(id);
    }

    public void save(VehicleModel vehicleModel) {
        vehicleModelRepository.save(vehicleModel);
    }

    public void deleteById(Integer id) {
        vehicleModelRepository.deleteById(id);
    }

    public List<VehicleModel> findByDescriptionContaining(String description) {
        return null;
    }
}
