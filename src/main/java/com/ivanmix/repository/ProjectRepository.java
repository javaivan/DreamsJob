package com.ivanmix.repository;

import org.springframework.data.repository.CrudRepository;
import com.ivanmix.entity.Project;

import java.util.List;

public interface ProjectRepository  extends CrudRepository<Project, Long> {

    Project findById(Long id);
/*
    Project findByIdAndAuthorId(Long id, Long authorId);

    List<Project> findByAuthorId(Long id);*/
}
