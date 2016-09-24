package com.ivanmix.repository;

import com.ivanmix.entity.Image;
import com.ivanmix.entity.UserRole;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ImageRepository extends PagingAndSortingRepository<Image, Long> {

    Image findByIdAndUserId(Long id, Long userId);
}

