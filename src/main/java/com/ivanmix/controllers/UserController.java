package com.ivanmix.controllers;

import com.google.common.collect.Lists;
import com.ivanmix.service.ProjectService;
import com.ivanmix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ivanmix.repository.ProjectRepository;
import com.ivanmix.repository.UserRepository;


@Controller
public class UserController {


    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String allProject(ModelMap model) {
        model.addAttribute("projects", projectService.findAll());
        return "projects";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String allUsers(ModelMap model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(ModelMap model){
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationPage(ModelMap model){
        return "registration";
    }

    @RequestMapping(value = "/bootstap", method = RequestMethod.GET)
    public String bootstapPage(ModelMap model){
        return "bootstap";
    }

}
