package com.fagenius.fleetapp.services;

import com.fagenius.fleetapp.models.Country;
import com.fagenius.fleetapp.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    //Return list of contries
    public List<Country> getCountries(){
        return countryRepository.findAll();
    }
    //Save new Country
    public void save(Country country){
        countryRepository.save(country);
    }
    //Get Country By Id
    public Optional<Country> findById(Integer id) {
        return countryRepository.findById(id);
    }
    //To delete country
    public void delete(Integer id) {
        countryRepository.deleteById(id);
    }
}

