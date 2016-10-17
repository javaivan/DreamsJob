package com.ivanmix.controller;


import com.ivanmix.service.ProjectService;
import com.ivanmix.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/admin-panel")
public class AdminPanelController {

    @Autowired
    private ProjectService projectService;

    @ResponseBody
    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String adminPanelPage(){
        return "project-new";
    }

    @RequestMapping(value = {"/verification-profiles", "/verification-profiles/"}, method = RequestMethod.GET)
    public String verificationProfilesPage(Model model){
        model.addAttribute("projects", projectService.findAllPending());
        return "projects/update";
    }
}
