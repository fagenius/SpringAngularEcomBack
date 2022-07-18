package com.fagenius.fleetapp.controllers;

import com.fagenius.fleetapp.models.Location;
import com.fagenius.fleetapp.models.VehicleMaintenance;
import com.fagenius.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleMaintenanceController {

    @Autowired
    private VehicleMaintenanceService vehicleMaintenanceService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehiclemaintenances")
    public String getLocations(Model model){

        model.addAttribute("vehiclemaintenances", vehicleMaintenanceService.findAll());
        model.addAttribute("suppliers", supplierService.findAll());
        model.addAttribute("vehicleservices", vehicleService.findAll());
        return "VehicleMaintenance";
    }

    @GetMapping("/vehiclemaintenances/findById")
    @ResponseBody
    public Optional<VehicleMaintenance> findById(Integer id) {
        return vehicleMaintenanceService.findById(id);
    }

    @PostMapping(value = "/vehiclemaintenances/addNew")
    public String save(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehiclemaintenances";
    }

    @RequestMapping(value="/vehiclemaintenances/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehiclemaintenances";
    }

    @RequestMapping(value="/vehiclemaintenances/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(Integer id) {
        vehicleMaintenanceService.deleteById(id);
        return "redirect:/vehiclemaintenances";
    }
}
