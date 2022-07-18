package com.fagenius.fleetapp.controllers;

import com.fagenius.fleetapp.models.EmployeeType;
import com.fagenius.fleetapp.models.Location;
import com.fagenius.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeTypeController {

    @Autowired
    private EmployeeTypeService employeeTypeService;

    @GetMapping("/employeestype")
    public String getEmployeeTypes(Model model){
        model.addAttribute("employeeTypes", employeeTypeService.findAll());
        return "EmployeeType";
    }

    @GetMapping("/employeestype/findById")
    @ResponseBody
    public Optional<EmployeeType> findById(Integer id) {
        return employeeTypeService.findById(id);
    }

    @GetMapping("/findByDescriptionContaining/{description}")
    public List<EmployeeType> findByDescriptionContaining(@PathVariable("description") String description) {
        return employeeTypeService.findByDescriptionContaining(description);
    }

    @PostMapping(value = "/employeestype/addNew")
    public String save(EmployeeType employeeType) {
        employeeTypeService.save(employeeType);
        return "redirect:/employeestype";
    }

    @RequestMapping(value="/employeestype/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(EmployeeType employeeType) {
        employeeTypeService.save(employeeType);
        return "redirect:/employeestype";
    }

    @RequestMapping(value="/employeestype/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(Integer id) {
        employeeTypeService.deleteById(id);
        return "redirect:/employeestype";
    }
}
