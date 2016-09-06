package com.ivanmix.controller;

import com.ivanmix.entity.Project;
import com.ivanmix.entity.User;
import com.ivanmix.form.PasswordForm;
import com.ivanmix.form.ProfileForm;
import com.ivanmix.form.RegistrationForm;
import com.ivanmix.service.ProjectService;
import com.ivanmix.service.UserService;
import com.ivanmix.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;


@Controller
public class UserController {


    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String allProject(ModelMap model) {
        model.addAttribute("projects", projectService.findAll());
        /*System.out.println(projectService.findAll());*/
        return "project-all";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String allUsers(ModelMap model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(ModelMap model){
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationPage(ModelMap model){
        model.addAttribute("registrationForm", new RegistrationForm());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String saveRegistrationContactsProfile(@Valid @ModelAttribute("registrationForm") RegistrationForm registrationForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.createUser(registrationForm);
        return "redirect:/registration/success";
    }

    @RequestMapping(value = "/registration/success", method = RequestMethod.GET)
    public String registrationSuccessPage(ModelMap model){
        return "registration-success";
    }

    @RequestMapping(value = "/user-profile", method = RequestMethod.GET)
    public String userProfile(ModelMap model) {
        User user = userService.findUserById(SecurityUtil.getCurrentUserId());
        model.addAttribute("profileForm", user);
        return "user-profile";
    }

    @RequestMapping(value = "/user-profile", method = RequestMethod.POST)
    public String saveUserProfile(@Valid @ModelAttribute("profileForm") ProfileForm profileForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "user-profile";
        }
        userService.updateUser(SecurityUtil.getCurrentUserId(), profileForm);
        return "redirect:/user-profile";
    }



    @RequestMapping(value = "/user-profile-change-password", method = RequestMethod.GET)
    public String userProfileChangePassword(ModelMap model) {
        PasswordForm password = new PasswordForm();
        model.addAttribute("password", password);
        return "user-profile-change-password";
    }

    @RequestMapping(value = "/user-profile-change-password", method = RequestMethod.POST)
    public String saveUserProfileChangePassword(@Valid @ModelAttribute("password") PasswordForm password, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "user-profile-change-password";
        }
        userService.updateUserPassword(SecurityUtil.getCurrentUserId(), password);
        return "redirect:/user-profile";
    }


    @RequestMapping(value = "/bootstap", method = RequestMethod.GET)
    public String bootstapPage(ModelMap model){
        return "bootstap";
    }

}
