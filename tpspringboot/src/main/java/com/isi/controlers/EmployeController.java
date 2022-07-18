package com.isi.controlers;

import com.isi.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeController {
    @Autowired
    private EmployeService employeService;
}
