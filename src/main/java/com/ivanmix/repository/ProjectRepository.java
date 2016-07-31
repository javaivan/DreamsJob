package com.ivanmix.repository;

import org.springframework.data.repository.CrudRepository;
import com.ivanmix.entity.Project;

public interface ProjectRepository  extends CrudRepository<Project, Long> {

    Project findById(Long id);

}
