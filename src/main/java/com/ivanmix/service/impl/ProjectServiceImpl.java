package com.ivanmix.service.impl;

import com.google.common.collect.Lists;
import com.ivanmix.entity.Project;
import com.ivanmix.repository.ProjectRepository;
import com.ivanmix.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project findUserById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void updateProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public List<Project> findAll() {
        return Lists.newArrayList(projectRepository.findAll());
    }
}
