package com.ivanmix.controller;

import com.ivanmix.entity.Project;
import com.ivanmix.entity.ProjectStatus;
import com.ivanmix.form.ProjectReplyForm;
import com.ivanmix.models.UploadImage;
import com.ivanmix.service.ImageService;
import com.ivanmix.service.ImageUploadService;
import com.ivanmix.service.ReplyService;
import com.ivanmix.service.ProjectService;
import com.ivanmix.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ReplyService replyService;

    @Autowired
    private ImageUploadService imageUploadService;

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/project-new", method = RequestMethod.GET)
    public String addNewProject(ModelMap model){
        model.addAttribute("project", new Project());
        model.addAttribute("status",  ProjectStatus.values());
        return "project-new";
    }

    @RequestMapping(value = "/project-new", method = RequestMethod.POST)
    public String saveNewProject(@Valid @ModelAttribute("project") Project project, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("status",  ProjectStatus.values());
            return "project-new";
        }
        projectService.create(project,SecurityUtil.getCurrentUserId());
        return "redirect:/project-new/success";
    }

    @RequestMapping(value = "/project-new/success", method = RequestMethod.GET)
    public String addNewProjectSuccess(ModelMap model){
        return "project-new-success";
    }

    @RequestMapping(value = "/project-reply", method = RequestMethod.POST)
    public String saveNewProjectReply(@RequestParam("id") Long id, @RequestParam("parent") Long parent, @RequestParam("reply") String reply) {
        replyService.create(reply, id, parent , SecurityUtil.getCurrentUserId());
        return "redirect:/";
    }

    @RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
    public String project(@PathVariable Long id, Model model) {
        Project project = projectService.findById(id);
        model.addAttribute("projectReplyForm", new ProjectReplyForm());
        if(project == null){
            return "project-not-found";
        } else {
            model.addAttribute("project", project);
            return "project";
        }
    }

    @RequestMapping(value = "/project-all", method = RequestMethod.GET)
    public String allProject(ModelMap model) {
        model.addAttribute("projects", projectService.findAllOpen());
        return "project-all";
    }

    @RequestMapping(value = "/project-my", method = RequestMethod.GET)
    public String allMyProject(ModelMap model) {
        model.addAttribute("projects", projectService.findByUserId(SecurityUtil.getCurrentUserId()));
        return "project-all";
    }


    @RequestMapping(value = "/project/update/{id}", method = RequestMethod.GET)
    public String updateProject(@PathVariable Long id, Model model) {
        Project project = projectService.findByIdAndUserId(id,SecurityUtil.getCurrentUserId());
        if(project == null){
            return "project-not-found";
        } else {
            model.addAttribute("status",  ProjectStatus.values());
            model.addAttribute("project", project);
            return "project-update";
        }
    }

    @RequestMapping(value = "/project/update", method = RequestMethod.POST)
    public String saveUpdateProject(@Valid @ModelAttribute("project") Project project, BindingResult bindingResult, Model model) {
        model.addAttribute("status",  ProjectStatus.values());
        if (bindingResult.hasErrors()) {
            return "project-update";
        } else if(projectService.findByIdAndUserId(project.getId(),SecurityUtil.getCurrentUserId()) == null) {
            return "project-update";
        }
        projectService.update(project);
        return "redirect:/project-update/success";
    }

    @RequestMapping(value="/project/add-image/{id}", method=RequestMethod.POST)
    @ResponseBody
    public String addImage(@RequestParam("image") MultipartFile file, @PathVariable Long id){
        UploadImage newImage = imageUploadService.uploadNewImage(file);
        UploadImage image = imageUploadService.approveImage(newImage);
        imageService.addImage(SecurityUtil.getCurrentUserId(),id,image);

        return "success";
    }

    @RequestMapping(value = "/project-update/success", method = RequestMethod.GET)
    public String successUpdateProject(ModelMap model){
        return "project-update-success";
    }


    @RequestMapping(value="/project/deleted-image/{id}", method=RequestMethod.GET)
    @ResponseBody
    public String deletedImage(@PathVariable Long id){
        imageService.deleteProjectImage(id, SecurityUtil.getCurrentUserId());
        return "success";
    }
}
