package com.ivanmix.service.impl;

import com.ivanmix.entity.Project;
import com.ivanmix.entity.Reply;
import com.ivanmix.entity.User;
import com.ivanmix.repository.ReplyRepository;
import com.ivanmix.repository.ProjectRepository;
import com.ivanmix.repository.UserRepository;
import com.ivanmix.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Reply findById(Long id) {
        return replyRepository.findById(id);
    }

    @Override
    public List<Reply> findByUserId(Long id) {
        return replyRepository.findByUserId(id);
    }

    @Override
    public List<Reply> findByProjectId(Long id) {
        return replyRepository.findByProjectId(id);
    }

    @Override
    @Transactional
    public Reply create(String reply, Long projectID, Long replyID, Long userID) {
        Reply projectReply = new Reply();
        Project project = projectRepository.findById(projectID);
        User user = userRepository.findById(userID);
        projectReply.setProject(project);
        projectReply.setUser(user);
        if(replyID != null){
            Reply pr = replyRepository.findById(replyID);
            projectReply.setParent(pr);
        }
        projectReply.setReply(reply);
        return replyRepository.save(projectReply);
    }

    @Override
    @Transactional
    public void update(Reply reply) {
        replyRepository.save(reply);
    }

    @Override
    public List<Reply> findByReply(String reply){
        return replyRepository.findByReply(reply);
    }
}
