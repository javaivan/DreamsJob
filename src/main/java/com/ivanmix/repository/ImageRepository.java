package com.ivanmix.repository;

import com.ivanmix.entity.Image;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ImageRepository extends PagingAndSortingRepository<Image, Long> {

    Image findByIdAndUserId(Long id, Long userId);
}

