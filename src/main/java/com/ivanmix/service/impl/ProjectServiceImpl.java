package com.ivanmix.service.impl;

import com.google.common.collect.Lists;
import com.ivanmix.entity.Image;
import com.ivanmix.entity.Project;
import com.ivanmix.entity.User;
import com.ivanmix.helper.ServiceHelper;
import com.ivanmix.models.UploadImage;
import com.ivanmix.repository.ProjectRepository;
import com.ivanmix.service.ProjectService;
import com.ivanmix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserService userService;


    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project findByIdAndUserId(Long id, Long userID) {
        return projectRepository.findByIdAndUserId(id, userID, ServiceHelper.getSortById());
    }

    @Override
    public Project create(Project project, Long userID) {
        User user = userService.findUserById(userID);
        project.setUser(user);
        System.out.println(project);
        return projectRepository.save(project);
    }

    /*
    *
    *     @Override
    @Transactional
    public void addUserPhoto(Long id, UploadImage image){
        User user = userRepository.findById(id);

        user.setBigImage(image.getBigImage());
        user.setSmallImage(image.getSmallImage());
        userRepository.save(user);
    }
    * */

    @Override
    public void update(Project p) {
        Project project = projectRepository.findById(p.getId());
        project.setTitle(p.getTitle());
        project.setDescription(p.getDescription());
        project.setStatus(p.getStatus());
        projectRepository.save(project);
    }

    @Override
    public List<Project> findAll() {
        return Lists.newArrayList(projectRepository.findAll(ServiceHelper.getSortById()));
    }

    @Override
    public List<Project> findAll(int page, int size) {
        return Lists.newArrayList(projectRepository.findAll(new PageRequest(page, size, ServiceHelper.getSortById())));
    }

    @Override
    public List<Project> findByUserId(Long id) {
        return Lists.newArrayList(projectRepository.findByUserId(id, ServiceHelper.getSortById()));
    }
}
