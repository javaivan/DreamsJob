package com.ivanmix.repository;

import com.ivanmix.entity.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByLogin(String login);

    User findById(Long id);
}

