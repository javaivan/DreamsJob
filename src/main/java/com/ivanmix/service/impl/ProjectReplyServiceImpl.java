package com.ivanmix.service.impl;

import com.ivanmix.entity.Project;
import com.ivanmix.entity.ProjectReply;
import com.ivanmix.entity.User;
import com.ivanmix.repository.ProjectReplyRepository;
import com.ivanmix.repository.ProjectRepository;
import com.ivanmix.repository.UserRepository;
import com.ivanmix.service.ProjectReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectReplyServiceImpl implements ProjectReplyService {

    @Autowired
    private ProjectReplyRepository replyRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ProjectReply findById(Long id) {
        return replyRepository.findById(id);
    }

    @Override
    public List<ProjectReply> findByUserId(Long id) {
        return replyRepository.findByUserId(id);
    }

    @Override
    public List<ProjectReply> findByProjectId(Long id) {
        return replyRepository.findByProjectId(id);
    }

    @Override
    public ProjectReply createProjectReply(String reply, Long projectId, Long projectReplyId, Long userId) {
        ProjectReply projectReply = new ProjectReply();
        Project project = projectRepository.findById(projectId);
        User user = userRepository.findById(userId);
        projectReply.setProject(project);
        projectReply.setUser(user);
        if(projectReplyId != null){
            ProjectReply pr = replyRepository.findById(projectReplyId);
            projectReply.setParent(pr);
        }
        projectReply.setReply(reply);
        return replyRepository.save(projectReply);
    }

    @Override
    public void updateProjectReply(ProjectReply reply) {
        replyRepository.save(reply);
    }
}
