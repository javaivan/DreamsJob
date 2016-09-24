package com.ivanmix.service;

import com.ivanmix.models.UploadImage;

public interface ImageService {
    void addImage(Long userId, Long projectId, UploadImage image);

    void deleteProjectImage(Long id, Long userId);
}
