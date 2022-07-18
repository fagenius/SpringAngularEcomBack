package com.fagenius.fleetapp.controllers;

import com.fagenius.fleetapp.models.Employee;
import com.fagenius.fleetapp.models.Location;
import com.fagenius.fleetapp.repositories.EmployeeRepository;
import com.fagenius.fleetapp.repositories.EmployeeTypeRepository;
import com.fagenius.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeTypeService employeeTypeService;
    @Autowired
    private JobTitleService jobTitleService;
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;



    @GetMapping("/employees")
    public String getEmployees(Model model){

        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("employeeTypes", employeeTypeService.findAll());
        model.addAttribute("jobTitles", jobTitleService.findAll());
        model.addAttribute("states", stateService.findAll());
        model.addAttribute("countries", countryService.getCountries());
        return "Employee";
    }

    @GetMapping("/employees/findById")
    @ResponseBody
    public Optional<Employee> findById(Integer id) {
        return employeeService.findById(id);
    }

    @PostMapping(value = "/employees/addNew")
    public String save(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value="/employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value="/employees/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteById(Integer id) {
        employeeService.deleteById(id);
        return "redirect:/employees";
    }
}
