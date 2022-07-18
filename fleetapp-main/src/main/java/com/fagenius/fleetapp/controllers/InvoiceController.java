package com.fagenius.fleetapp.controllers;

import com.fagenius.fleetapp.models.Invoice;
import com.fagenius.fleetapp.models.Location;
import com.fagenius.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private InvoiceStatusService invoiceStatusService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/invoices")
    public String getInvoices(Model model){

        model.addAttribute("invoices", invoiceService.findAll());
        model.addAttribute("invoiceStatus", invoiceStatusService.findAll());
        model.addAttribute("clients", clientService.findAll());
        return "Invoice";
    }

    @GetMapping("/invoices/findById")
    @ResponseBody
    public Optional<Invoice> findById(Integer id) {
        return invoiceService.findById(id);
    }

    /*@GetMapping("/findByDescriptionInvoice/{description}")
    public List<Invoice> findByDescriptionInvoice(@PathVariable("description") String description) {
        return invoiceService.findByDescriptionInvoice(description);
    }*/

    @PostMapping(value = "/invoices/addNew")
    public String save(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping(value="/invoices/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping(value="/invoices/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(Integer id) {
        invoiceService.deleteById(id);
        return "redirect:/invoices";
    }
}
