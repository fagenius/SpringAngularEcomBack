package com.fagenius.fleetapp.controllers;

import com.fagenius.fleetapp.models.Contact;
import com.fagenius.fleetapp.models.VehicleModel;
import com.fagenius.fleetapp.services.ContactService;
import com.fagenius.fleetapp.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ContactController {

        @Autowired
        private ContactService contactService;

        @GetMapping("/contacts")
        public String getVehicleModels(Model model){
            model.addAttribute("contacts", contactService.findAll());
            return "Contact";
        }

        @GetMapping("/contacts/findById")
        @ResponseBody
        public Optional<Contact> findById(Integer id) {
            return contactService.findById(id);
        }

        @PostMapping(value = "/contacts/addNew")
        public String save(Contact contact) {
            contactService.save(contact);
            return "redirect:/contacts";
        }

        @RequestMapping(value="/contacts/update", method = {RequestMethod.PUT, RequestMethod.GET})
        public String update(Contact contact) {
            contactService.save(contact);
            return "redirect:/contacts";
        }

        @RequestMapping(value="/contacts/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
        public String deleteById(Integer id) {
            contactService.deleteById(id);
            return "redirect:/contacts";
        }
}
