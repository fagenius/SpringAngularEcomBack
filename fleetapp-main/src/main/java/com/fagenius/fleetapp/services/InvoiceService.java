package com.fagenius.fleetapp.services;

import com.fagenius.fleetapp.models.Invoice;
import com.fagenius.fleetapp.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> findById(Integer id) {
        return invoiceRepository.findById(id);
    }

    /*public List<Invoice> findByDescriptionInvoice(String description) {
        return null;
    }*/

    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    public void deleteById(Integer id) {
        invoiceRepository.deleteById(id);
    }
}
