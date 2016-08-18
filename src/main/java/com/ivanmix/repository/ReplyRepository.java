package com.ivanmix.repository;

import com.ivanmix.entity.Reply;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReplyRepository extends CrudRepository<Reply, Long> {

    Reply findById(Long id);

    List<Reply> findByUserId(Long id);

    List<Reply> findByProjectId(Long id);
}
