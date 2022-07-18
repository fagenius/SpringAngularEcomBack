package com.fagenius.fleetapp.controllers;

import com.fagenius.fleetapp.models.Location;
import com.fagenius.fleetapp.models.VehicleModel;
import com.fagenius.fleetapp.services.CountryService;
import com.fagenius.fleetapp.services.LocationService;
import com.fagenius.fleetapp.services.StateService;
import com.fagenius.fleetapp.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleModelController {

    @Autowired
    private VehicleModelService vehicleModelService;

    @GetMapping("/vehiclemodels")
    public String getVehicleModels(Model model){
        model.addAttribute("vehiclemodels", vehicleModelService.findAll());
        return "VehicleModel";
    }

    @GetMapping("/vehiclemodels/findById")
    @ResponseBody
    public Optional<VehicleModel> findById(Integer id) {
        return vehicleModelService.findById(id);
    }

    /*@GetMapping("/findByDescriptionContaining/{description}")
    public List<VehicleModel> findByDescriptionContaining(@PathVariable("description") String description) {
        return vehicleModelService.findByDescriptionContaining(description);
    }*/

    @PostMapping(value = "/vehiclemodels/addNew")
    public String save(VehicleModel vehicleModel) {
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehiclemodels";
    }

    @RequestMapping(value="/vehiclemodels/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleModel vehicleModel) {
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehiclemodels";
    }

    @RequestMapping(value="/vehiclemodels/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(Integer id) {
        vehicleModelService.deleteById(id);
        return "redirect:/vehiclemodels";
    }
}
