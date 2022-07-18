package com.fagenius.fleetapp.controllers;

import com.fagenius.fleetapp.models.Location;
import com.fagenius.fleetapp.services.CountryService;
import com.fagenius.fleetapp.services.LocationService;
import com.fagenius.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;
    @Autowired
    private CountryService countryService;
    @Autowired	private StateService stateService;

    @GetMapping("/locations")
    public String getLocations(Model model){

        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("states", stateService.findAll());
        return "Location";
    }

    @GetMapping("/locations/findById")
    @ResponseBody
    public Optional<Location> findById(Integer id) {
        return locationService.findById(id);
    }

   /* @GetMapping("/findByDescriptionContaining/{description}")
    public List<Location> findByDescriptionContaining(@PathVariable("description") String description) {
        return locationService.findByDescriptionContaining(description);
    }*/

    @PostMapping(value = "/locations/addNew")
    public String save(Location location) {
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping(value="/locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Location location) {
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping(value="/locations/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(Integer id) {
        locationService.deleteById(id);
        return "redirect:/locations";
    }
}
