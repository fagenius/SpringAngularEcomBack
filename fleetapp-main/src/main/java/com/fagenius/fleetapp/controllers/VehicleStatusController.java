package com.fagenius.fleetapp.controllers;

import com.fagenius.fleetapp.models.Location;
import com.fagenius.fleetapp.models.VehicleStatus;
import com.fagenius.fleetapp.models.VehicleType;
import com.fagenius.fleetapp.services.CountryService;
import com.fagenius.fleetapp.services.LocationService;
import com.fagenius.fleetapp.services.StateService;
import com.fagenius.fleetapp.services.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleStatusController {

    @Autowired
    private VehicleStatusService vehicleStatusService;

    @GetMapping("/vehiclestatus")
    public String getVehilceStatus(Model model){
        model.addAttribute("vehilcestatus", vehicleStatusService.findAll());
        return "VehicleStatus";
    }

    @GetMapping("/vehiclestatus/findById")
    @ResponseBody
    public Optional<VehicleStatus> findById(Integer id) {
        return vehicleStatusService.findById(id);
    }

    /*@GetMapping("/findByDescriptionContaining/{description}")
    public List<VehicleStatus> findByDescriptionContaining(@PathVariable("description") String description) {
        return vehicleStatusService.findByDescriptionContaining(description);
    }*/

    @PostMapping(value = "/vehiclestatus/addNew")
    public String save(VehicleStatus vehicleStatus) {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehiclestatus";
    }

    @RequestMapping(value="/vehiclestatus/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleStatus vehicleStatus) {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehiclestatus";
    }

    @RequestMapping(value="/vehiclestatus/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(Integer id) {
        vehicleStatusService.deleteById(id);
        return "redirect:/vehiclestatus";
    }
}
