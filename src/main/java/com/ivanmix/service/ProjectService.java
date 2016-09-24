package com.ivanmix.service;

import com.ivanmix.entity.Project;

import java.util.List;

public interface ProjectService {

    Project findById(Long id);

    Project findByIdAndUserId(Long id, Long userID);

    Project create(Project project, Long userID);

    void update(Project project);

    List<Project> findAll();

    List<Project> findAll(int page, int size);

    List<Project> findByUserId(Long id);

}
