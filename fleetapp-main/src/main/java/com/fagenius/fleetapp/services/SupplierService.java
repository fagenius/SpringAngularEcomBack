package com.fagenius.fleetapp.services;

import com.fagenius.fleetapp.models.Client;
import com.fagenius.fleetapp.models.Supplier;
import com.fagenius.fleetapp.repositories.ClientRepository;
import com.fagenius.fleetapp.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    public Optional<Supplier> findById(Integer id) {
        return supplierRepository.findById(id);
    }

    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    public void deleteById(Integer id) {
        supplierRepository.deleteById(id);
    }

}
