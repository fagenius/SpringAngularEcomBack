package com.fagenius.fleetapp.controllers;

import com.fagenius.fleetapp.models.Country;
import com.fagenius.fleetapp.models.State;
import com.fagenius.fleetapp.models.VehicleMovement;
import com.fagenius.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMovementController {

    @Autowired
    private VehicleMovementService vehicleMovementService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private LocationService locationService;

    //Get All States
    @GetMapping("/vehiclemovements")
    public String findAll(Model model){
        model.addAttribute("vehiclemovements", vehicleMovementService.findAll());
        model.addAttribute("vehicles",vehicleService.findAll());
        model.addAttribute("locations", locationService.findAll());
        return "VehicleMovement";
    }

    @RequestMapping("vehiclemovements/findById")
    @ResponseBody
    public Optional<VehicleMovement> findById(Integer id)
    {
        return vehicleMovementService.findById(id);
    }

    //Add State
    @PostMapping(value="vehiclemovements/addNew")
    public String addNew(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehiclemovements";
    }

    @RequestMapping(value="vehiclemovements/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMovement vehicleMovement) {
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehiclemovements";
    }

    @RequestMapping(value="vehiclemovements/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleMovementService.delete(id);
        return "redirect:/vehiclemovements";
    }
}
