package com.ivanmix.service;

import com.ivanmix.entity.Project;

import java.util.List;

public interface ProjectService {

    Project findById(Long id);

    Project findByIdAndAuthorId(Long id, Long authorId);

    Project createProject(Project project);

    void updateProject(Project project);

    List<Project> findAll();

    List<Project> findProjecByAuthorId(Long id);

}
