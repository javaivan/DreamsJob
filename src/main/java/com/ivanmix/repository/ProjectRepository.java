package com.ivanmix.repository;

import com.ivanmix.entity.Project;
import com.ivanmix.entity.ProjectStatus;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProjectRepository  extends PagingAndSortingRepository<Project, Long> {

    Project findById(Long id);

    Project findByIdAndUserId(Long id, Long userId);

    List<Project> findByUserId(Long id, Sort sort);

    List<Project> findByStatus(ProjectStatus status, Sort sort);
}
