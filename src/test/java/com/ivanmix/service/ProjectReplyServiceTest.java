package com.ivanmix.service;

import com.ivanmix.config.SpringConfig;
import com.ivanmix.entity.ProjectReply;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ProjectReplyServiceTest {

    //ProjectReply findById(Long id);

    //List<ProjectReply> findByUserId(Long id);

    //List<ProjectReply> findByProjectId(Long id);

    //ProjectReply createProjectReplyTest(String reply, Long projectId, Long ProjectReplyId, Long userId);

    @Autowired
    ProjectReplyService projectReplyService;

    @Test
    public void createProjectReplyTest(){
        projectReplyService.createProjectReply("99999999999999",(long)1,(long)1,(long)1);
    }

    //void updateProjectReply(ProjectReply reply);
}
