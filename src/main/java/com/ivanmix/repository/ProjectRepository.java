package com.ivanmix.repository;

import org.springframework.data.repository.CrudRepository;
import com.ivanmix.entity.Project;

import java.util.List;

public interface ProjectRepository  extends CrudRepository<Project, Long> {

    Project findById(Long id);

    Project findByIdAndUserId(Long id, Long userId);

    List<Project> findByUserId(Long id);
}
