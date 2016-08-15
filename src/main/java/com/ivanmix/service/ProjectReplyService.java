package com.ivanmix.service;

import com.ivanmix.entity.ProjectReply;

import java.util.List;

public interface ProjectReplyService {

    ProjectReply findById(Long id);

    List<ProjectReply> findByUserId(Long id);

    List<ProjectReply> findByProjectId(Long id);

    ProjectReply createProjectReply(ProjectReply projectReply, Long projectId, Long userId);

    void updateProjectReply(ProjectReply reply);
}
