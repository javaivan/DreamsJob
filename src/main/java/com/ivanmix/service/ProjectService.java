package com.ivanmix.service;

import com.ivanmix.entity.Project;

import java.util.List;

public interface ProjectService {

    Project findUserById(Long id);

    Project createProject(Project project);

    void updateProject(Project project);

    List<Project> findAll();
}
