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
    public Project findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project findByIdAndAuthorId(Long id, Long authorId) {
        return projectRepository.findByIdAndAuthorId(id, authorId);
    }

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void updateProject(Project p) {
        Project project = projectRepository.findById(p.getId());
        project.setTitle(p.getTitle());
        project.setDescription(p.getDescription());
        projectRepository.save(project);
    }

    @Override
    public List<Project> findAll() {
        return Lists.newArrayList(projectRepository.findAll());
    }

    @Override
    public List<Project> findProjecByAuthorId(Long id) {
        return Lists.newArrayList(projectRepository.findByAuthorId(id));
    }


}
