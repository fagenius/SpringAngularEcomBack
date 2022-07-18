package com.fagenius.fleetapp.services;

import com.fagenius.fleetapp.models.EmployeeType;
import com.fagenius.fleetapp.models.Location;
import com.fagenius.fleetapp.repositories.EmployeeTypeRepository;
import com.fagenius.fleetapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {
    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;
    public List<EmployeeType> findAll() {
        return (List<EmployeeType>) employeeTypeRepository.findAll();
    }

    public Optional<EmployeeType> findById(Integer id) {
        return employeeTypeRepository.findById(id);
    }

    public void save(EmployeeType employeeType) {
        employeeTypeRepository.save(employeeType);
    }

    public void deleteById(Integer id) {
        employeeTypeRepository.deleteById(id);
    }

    public List<EmployeeType> findByDescriptionContaining(String description) {
        return null;
    }
}
