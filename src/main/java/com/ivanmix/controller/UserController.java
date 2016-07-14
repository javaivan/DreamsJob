package com.ivanmix.controller;

import com.ivanmix.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    UserService userService = new UserService();


    @RequestMapping(value = "/all-user", method = RequestMethod.GET)
    public String AllUser(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "all-user";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginUser() {
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationUser() {
        return "registration";
    }
}


/*

@Controller
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        model.addAttribute("message", "Spring 3 MVC Hello World");
        return "hello";

    }


    @RequestMapping(value = "/bootstap", method = RequestMethod.GET)
    public String bootstapPage(ModelMap model) {
        return "bootstap";
    }

    @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {

        ModelAndView model = new ModelAndView();
        model.setViewName("hello");
        model.addObject("msg", name);

        return model;

    }

}

* */