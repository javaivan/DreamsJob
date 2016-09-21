package com.ivanmix.service;

import com.ivanmix.models.UploadImage;

/**
 * Created by ivan on 20.09.2016.
 */
public interface ImageService {
    void addImage(Long userId, Long projectId, UploadImage image);
}
