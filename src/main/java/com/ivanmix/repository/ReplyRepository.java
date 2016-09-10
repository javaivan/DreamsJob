package com.ivanmix.repository;

import com.ivanmix.entity.Reply;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ReplyRepository extends PagingAndSortingRepository<Reply, Long> {

    Reply findById(Long id);

    List<Reply> findByUserId(Long id, Sort sort);

    List<Reply> findByProjectId(Long id, Sort sort);

    List<Reply> findByReply(String reply, Sort sort);

    List<Reply> findByReaderId(Long id, Sort sort);

}
