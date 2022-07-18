package com.fagenius.fleetapp.services;

import com.fagenius.fleetapp.models.Contact;
import com.fagenius.fleetapp.models.VehicleModel;
import com.fagenius.fleetapp.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Optional<Contact> findById(Integer id) {
        return contactRepository.findById(id);
    }

    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    public void deleteById(Integer id) {
        contactRepository.deleteById(id);
    }
}
