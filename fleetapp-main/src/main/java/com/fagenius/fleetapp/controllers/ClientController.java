package com.fagenius.fleetapp.controllers;

import com.fagenius.fleetapp.models.Client;
import com.fagenius.fleetapp.models.Location;
import com.fagenius.fleetapp.services.ClientService;
import com.fagenius.fleetapp.services.CountryService;
import com.fagenius.fleetapp.services.LocationService;
import com.fagenius.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private CountryService countryService;
    @Autowired	private StateService stateService;

    @GetMapping("/clients")
    public String getClients(Model model){
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("states", stateService.findAll());
        return "Client";
    }

    @GetMapping("/clients/findById")
    @ResponseBody
    public Optional<Client> findById(Integer id) {
        return clientService.findById(id);
    }

    @PostMapping(value = "/clients/addNew")
    public String save(Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping(value="/clients/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping(value="/clients/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(Integer id) {
        clientService.deleteById(id);
        return "redirect:/clients";
    }
}
