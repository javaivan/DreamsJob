package com.ivanmix.service;

import com.ivanmix.entity.Reply;

import java.util.List;

public interface ReplyService {

    Reply findById(Long id);

    List<Reply> findByUserId(Long id);

    List<Reply> findByProjectId(Long id);

    Reply createProjectReply(String reply, Long projectId, Long ProjectReplyId, Long userId);

    void updateProjectReply(Reply reply);
}
