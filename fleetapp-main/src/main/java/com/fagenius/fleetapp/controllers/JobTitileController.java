package com.fagenius.fleetapp.controllers;

import com.fagenius.fleetapp.models.Country;
import com.fagenius.fleetapp.models.JobTitle;
import com.fagenius.fleetapp.models.Location;
import com.fagenius.fleetapp.services.CountryService;
import com.fagenius.fleetapp.services.JobTitleService;
import com.fagenius.fleetapp.services.LocationService;
import com.fagenius.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobTitileController {

    @Autowired
    private JobTitleService jobTitleService;

    @GetMapping("/jobstitles")
    public String getJobTitles(Model model){

        model.addAttribute("jobstitles", jobTitleService.findAll());

        return "JobTitle";
    }

    @GetMapping("/jobstitles/findById")
    @ResponseBody
    public Optional<JobTitle> findById(Integer id) {
        return jobTitleService.findById(id);
    }

    /*@GetMapping("/findByDescriptionContaining/{description}")
    public List<JobTitle> findByDescriptionContaining(@PathVariable("description") String description) {
        return jobTitleService.findByDescriptionContaining(description);
    }*/

    @PostMapping(value = "/jobstitles/addNew")
    public String save(JobTitle jobTitle) {
        jobTitleService.save(jobTitle);
        return "redirect:/jobstitles";
    }

    @RequestMapping(value="/jobstitles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(JobTitle jobTitle) {
        jobTitleService.save(jobTitle);
        return "redirect:/jobstitles";
    }

    @RequestMapping(value="/jobstitles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(Integer id) {
        jobTitleService.deleteById(id);
        return "redirect:/jobstitles";
    }
}
