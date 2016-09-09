package com.ivanmix.service;

import com.ivanmix.entity.Reply;

import java.util.List;

public interface ReplyService {

    Reply findById(Long id);

    List<Reply> findByUserId(Long id);

    List<Reply> findByProjectId(Long id);

    List<Reply> findToUserId(Long id);

    Reply create(String reply, Long projectId, Long ProjectReplyId, Long userId);

    void update(Reply reply);

    List<Reply> findByReply(String reply);

    List<Reply> findToReaderId(Long id);

}
