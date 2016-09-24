package com.ivanmix.repository;

import com.ivanmix.entity.User;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByLogin(String login);

    User findByEmail(String email);

    User findById(Long id);
}

