package com.ivanmix.repository;

import com.ivanmix.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByLogin(String login);

    User findById(Long id);
}

