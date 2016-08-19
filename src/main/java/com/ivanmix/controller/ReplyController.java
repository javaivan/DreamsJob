package com.ivanmix.controller;

import com.ivanmix.service.ReplyService;
import com.ivanmix.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @RequestMapping(value = "/replies-my", method = RequestMethod.GET)
    public String myReplies(Model model) {
        model.addAttribute("replies", replyService.findByUserId(SecurityUtil.getCurrentUserId()));
        return "replies-my";
    }
}
