package com.fagenius.fleetapp.services;

import com.fagenius.fleetapp.models.JobTitle;
import com.fagenius.fleetapp.models.Location;
import com.fagenius.fleetapp.repositories.JobTitleRepository;
import com.fagenius.fleetapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {
    @Autowired
    private JobTitleRepository jobTitleRepository;
    public List<JobTitle> findAll() {
        return (List<JobTitle>) jobTitleRepository.findAll();
    }

    public Optional<JobTitle> findById(Integer id) {
        return jobTitleRepository.findById(id);
    }

    public void save(JobTitle jobTitle) {
        jobTitleRepository.save(jobTitle);
    }

    public void deleteById(Integer id) {
        jobTitleRepository.deleteById(id);
    }

    public List<JobTitle> findByDescriptionContaining(String description) {
        return null;
    }
}
