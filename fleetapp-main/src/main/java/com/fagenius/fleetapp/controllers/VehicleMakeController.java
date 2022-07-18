package com.fagenius.fleetapp.controllers;

import com.fagenius.fleetapp.models.Location;
import com.fagenius.fleetapp.models.VehicleMake;
import com.fagenius.fleetapp.services.CountryService;
import com.fagenius.fleetapp.services.LocationService;
import com.fagenius.fleetapp.services.StateService;
import com.fagenius.fleetapp.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMakeController {

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @GetMapping("/vehiclemakes")
    public String getvehicleMakes(Model model){
        model.addAttribute("vehilceMakes", vehicleMakeService.findAll());
        return "VehicleMake";
    }

    @GetMapping("/vehiclemakes/findById")
    @ResponseBody
    public Optional<VehicleMake> findById(Integer id) {
        return vehicleMakeService.findById(id);
    }

   /* @GetMapping("/findByDescriptionContaining/{description}")
    public List<VehicleMake> findByDescriptionContaining(@PathVariable("description") String description) {
        return vehicleMakeService.findByDescriptionContaining(description);
    }*/

    @PostMapping(value = "/vehiclemakes/addNew")
    public String save(VehicleMake vehicleMake) {
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehiclemakes";
    }

    @RequestMapping(value="/vehiclemakes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMake vehicleMake) {
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehiclemakes";
    }

    @RequestMapping(value="/vehiclemakes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(Integer id) {
        vehicleMakeService.deleteById(id);
        return "redirect:/vehiclemakes";
    }
}
