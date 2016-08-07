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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;


@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/project-new", method = RequestMethod.GET)
    public String addNewProject(ModelMap model){
        model.addAttribute("project", new Project());
        return "project-new";
    }


    @RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
    public String project(@PathVariable Long id, Model model) {
        Project project = projectService.findById(id);
        if(project == null){
            return "project-not-found";
        } else {
            model.addAttribute("project", project);
            return "project";
        }
    }


    @RequestMapping(value = "/project-new", method = RequestMethod.POST)
    public String saveNewProject(@Valid @ModelAttribute("project") Project project, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "project-new";
        }
        project.setAuthorId(SecurityUtil.getCurrentUserId());
        projectService.createProject(project);
        return "redirect:/project-new/success";
    }

    @RequestMapping(value = "/project-new/success", method = RequestMethod.GET)
    public String addNewProjectSuccess(ModelMap model){
        return "project-new-success";
    }


    @RequestMapping(value = "/project-all", method = RequestMethod.GET)
    public String allProject(ModelMap model) {
        model.addAttribute("projects", projectService.findAll());
        return "project-all";
    }

    @RequestMapping(value = "/project-my", method = RequestMethod.GET)
    public String allMyProject(ModelMap model) {
        model.addAttribute("projects", projectService.findProjecByAuthorId(SecurityUtil.getCurrentUserId()));
        return "project-all";
    }

    @RequestMapping(value = "/project/update/{id}", method = RequestMethod.GET)
    public String updateProject(@PathVariable Long id, Model model) {
        Project project = projectService.findByIdAndAuthorId(id,SecurityUtil.getCurrentUserId());
        if(project == null){
            return "project-not-found";
        } else {
            model.addAttribute("project", project);
            return "project-update";
        }
    }

    @RequestMapping(value = "/project/update", method = RequestMethod.POST)
    public String saveUpdateProject(@Valid @ModelAttribute("project") Project project, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "project-update";
        } else if(projectService.findByIdAndAuthorId(project.getId(),SecurityUtil.getCurrentUserId()) == null) {
            return "project-update";
        }
        projectService.updateProject(project);
        return "redirect:/project-update/success";
    }

    @RequestMapping(value = "/project-update/success", method = RequestMethod.GET)
    public String successUpdateProject(ModelMap model){
        return "project-update-success";
    }
}
