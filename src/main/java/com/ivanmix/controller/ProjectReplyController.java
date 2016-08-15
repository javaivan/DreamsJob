package com.ivanmix.controller;

import com.ivanmix.entity.Project;
import com.ivanmix.form.ProjectReplyForm;
import com.ivanmix.service.ProjectReplyService;
import com.ivanmix.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProjectReplyController {

    @Autowired
    ProjectReplyService projectReplyService;

    @RequestMapping(value = "/project-replies", method = RequestMethod.GET)
    public String myProjectReplies(Model model) {
        model.addAttribute("replies", projectReplyService.findByUserId(SecurityUtil.getCurrentUserId()));
        return "project-replies";
    }
}
