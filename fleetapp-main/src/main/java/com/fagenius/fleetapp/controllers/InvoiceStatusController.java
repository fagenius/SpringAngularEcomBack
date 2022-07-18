package com.fagenius.fleetapp.controllers;

import com.fagenius.fleetapp.models.InvoiceStatus;
import com.fagenius.fleetapp.models.Location;
import com.fagenius.fleetapp.services.CountryService;
import com.fagenius.fleetapp.services.InvoiceStatusService;
import com.fagenius.fleetapp.services.LocationService;
import com.fagenius.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceStatusController {

    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @GetMapping("/invoicestatus")
    public String getInvoicesStatus(Model model){

        model.addAttribute("invoicestatus", invoiceStatusService.findAll());
        return "InvoiceStatus";
    }

    @GetMapping("/invoicestatus/findById")
    @ResponseBody
    public Optional<InvoiceStatus> findById(Integer id) {
        return invoiceStatusService.findById(id);
    }

    @GetMapping("/findByDescription/{description}")
    public List<InvoiceStatus> findByDescription(@PathVariable("description") String description) {
        return invoiceStatusService.findByDescription(description);
    }

    @PostMapping(value = "/invoicestatus/addNew")
    public String save(InvoiceStatus invoiceStatus) {
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoicestatus";
    }

    @RequestMapping(value="/invoicestatus/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(InvoiceStatus invoiceStatus) {
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoicestatus";
    }

    @RequestMapping(value="/invoicestatus/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(Integer id) {
        invoiceStatusService.deleteById(id);
        return "redirect:/invoicestatus";
    }
}
