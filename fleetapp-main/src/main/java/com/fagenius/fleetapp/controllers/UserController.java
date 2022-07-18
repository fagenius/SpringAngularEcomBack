package com.fagenius.fleetapp.controllers;

import com.fagenius.fleetapp.models.Country;
import com.fagenius.fleetapp.models.State;
import com.fagenius.fleetapp.models.User;
import com.fagenius.fleetapp.repositories.UserRepository;
import com.fagenius.fleetapp.services.CountryService;
import com.fagenius.fleetapp.services.StateService;
import com.fagenius.fleetapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private StateService stateService;
    //Get All Users
    @GetMapping("/users")
    public String findAll(Model model){
        model.addAttribute("users", userService.findAll());
        model.addAttribute( "countries", countryService.getCountries());
        model.addAttribute( "states",stateService.findAll());

        return "User";
    }
    @PostMapping("/users/addNew")
    public RedirectView addUser(User user, RedirectAttributes redir){
        userService.save(user);
        RedirectView redirectView = new RedirectView("/login",true);
        redir.addFlashAttribute( "message","You successfully registred! You can now login" );
        return redirectView;
    }

    @RequestMapping("users/findById")
    @ResponseBody
    public Optional<User> findById(Integer id)
    {
        return userService.findById(id);
    }

    @RequestMapping(value="users/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @RequestMapping(value="users/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
