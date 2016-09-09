package com.ivanmix.repository;

import org.springframework.data.repository.CrudRepository;
import com.ivanmix.entity.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProjectRepository  extends PagingAndSortingRepository<Project, Long> {

    Project findById(Long id);

    Project findByIdAndUserId(Long id, Long userId);

    List<Project> findByUserId(Long id);
}
