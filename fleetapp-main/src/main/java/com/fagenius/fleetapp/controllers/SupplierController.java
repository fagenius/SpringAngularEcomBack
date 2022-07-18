package com.fagenius.fleetapp.controllers;

import com.fagenius.fleetapp.models.Client;
import com.fagenius.fleetapp.models.Supplier;
import com.fagenius.fleetapp.services.ClientService;
import com.fagenius.fleetapp.services.CountryService;
import com.fagenius.fleetapp.services.StateService;
import com.fagenius.fleetapp.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class SupplierController {

    @Autowired
    private SupplierService supplierService;
    @Autowired
    private CountryService countryService;
    @Autowired	private StateService stateService;

    @GetMapping("/suppliers")
    public String getClients(Model model){
        model.addAttribute("suppliers", supplierService.findAll());
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("states", stateService.findAll());
        return "Supplier";
    }

    @GetMapping("/suppliers/findById")
    @ResponseBody
    public Optional<Supplier> findById(Integer id) {
        return supplierService.findById(id);
    }

    @PostMapping(value = "/suppliers/addNew")
    public String save(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping(value="/suppliers/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Supplier supplier) {
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping(value="/suppliers/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(Integer id) {
        supplierService.deleteById(id);
        return "redirect:/suppliers";
    }
}
