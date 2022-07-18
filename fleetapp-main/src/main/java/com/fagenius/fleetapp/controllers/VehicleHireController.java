package com.fagenius.fleetapp.controllers;

import com.fagenius.fleetapp.models.VehicleHire;
import com.fagenius.fleetapp.models.VehicleMaintenance;
import com.fagenius.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleHireController {

    @Autowired
    private VehicleHireService vehicleHireService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehiclehires")
    public String getLocations(Model model){

        model.addAttribute("vehiclehireservices", vehicleHireService.findAll());
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("vehicleservices", vehicleService.findAll());
        model.addAttribute("locations",locationService.findAll());
        return "VehicleHire";
    }

    @GetMapping("/vehiclehires/findById")
    @ResponseBody
    public Optional<VehicleHire> findById(Integer id) {
        return vehicleHireService.findById(id);
    }

    @PostMapping(value = "/vehiclehires/addNew")
    public String save(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehiclehires";
    }

    @RequestMapping(value="/vehiclehires/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehiclehires";
    }

    @RequestMapping(value="/vehiclehires/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(Integer id) {
        vehicleHireService.deleteById(id);
        return "redirect:/vehiclehires";
    }
}
