package com.ivanmix.repository;

import com.ivanmix.entity.Project;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProjectRepository  extends PagingAndSortingRepository<Project, Long> {

    Project findById(Long id);

    Project findByIdAndUserId(Long id, Long userId, Sort sort);

    List<Project> findByUserId(Long id, Sort sort);
}
