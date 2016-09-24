package com.ivanmix.repository;

import com.ivanmix.entity.UserRole;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRoleRepository extends PagingAndSortingRepository<UserRole, Long> {
    List<UserRole> findByRole(String role, Pageable pageable);
}

