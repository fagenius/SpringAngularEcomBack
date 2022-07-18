package com.isi.services;

import com.isi.entities.Employe;
import com.isi.repositories.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {
    @Autowired
    private EmployeRepository employeRepository;

    public List<Employe> findAll() {
        return employeRepository.findAll();
    }

    public Optional<Employe> findById(Integer id) {
        return  employeRepository.findById(id);
    }

    public void save(Employe employee) {
        employeRepository.save(employee);
    }

    public void deleteById(Integer id) {
        employeRepository.deleteById(id);
    }

}
