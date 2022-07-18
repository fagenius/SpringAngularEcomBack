package com.fagenius.fleetapp.controllers;

import com.fagenius.fleetapp.models.Location;
import com.fagenius.fleetapp.models.VehicleType;
import com.fagenius.fleetapp.services.CountryService;
import com.fagenius.fleetapp.services.LocationService;
import com.fagenius.fleetapp.services.StateService;
import com.fagenius.fleetapp.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GetMapping("/vehicletypes")
    public String getVehicleType(Model model){

        model.addAttribute("vehilceTypes", vehicleTypeService.findAll());

        return "VehicleType";
    }

    @GetMapping("/vehicletypes/findById")
    @ResponseBody
    public Optional<VehicleType> findById(Integer id) {
        return vehicleTypeService.findById(id);
    }

    /*@GetMapping("/findByDescriptionContaining/{description}")
    public List<VehicleType> findByDescriptionContaining(@PathVariable("description") String description) {
        return vehicleTypeService.findByDescriptionContaining(description);
    }*/

    @PostMapping(value = "/vehicletypes/addNew")
    public String save(VehicleType vehicleType) {
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicletypes";
    }

    @RequestMapping(value="/vehicletypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleType vehicleType) {
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicletypes";
    }

    @RequestMapping(value="/vehicletypes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(Integer id) {
        vehicleTypeService.deleteById(id);
        return "redirect:/vehicletypes";
    }
}
