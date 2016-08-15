package com.ivanmix.repository;

import com.ivanmix.entity.ProjectReply;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectReplyRepository extends CrudRepository<ProjectReply, Long> {

    ProjectReply findById(Long id);

    List<ProjectReply> findByUserId(Long id);

    List<ProjectReply> findByProjectId(Long id);
}
