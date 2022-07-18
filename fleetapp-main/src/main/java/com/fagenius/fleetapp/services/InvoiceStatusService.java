package com.fagenius.fleetapp.services;

import com.fagenius.fleetapp.models.Invoice;
import com.fagenius.fleetapp.models.InvoiceStatus;
import com.fagenius.fleetapp.models.Location;
import com.fagenius.fleetapp.repositories.InvoiceRepository;
import com.fagenius.fleetapp.repositories.InvoiceStatusRepository;
import com.fagenius.fleetapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusService {
    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;
    public List<InvoiceStatus> findAll() {
        return (List<InvoiceStatus>) invoiceStatusRepository.findAll();
    }

    public Optional<InvoiceStatus> findById(Integer id) {
        return invoiceStatusRepository.findById(id);
    }

    public void save(InvoiceStatus invoiceStatus) {
        invoiceStatusRepository.save(invoiceStatus);
    }

    public void deleteById(Integer id) {
        invoiceStatusRepository.deleteById(id);
    }

    public List<InvoiceStatus> findByDescription(String description) {
        return null;
    }
}
