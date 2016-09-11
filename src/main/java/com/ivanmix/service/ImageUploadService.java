package com.ivanmix.service;

import com.ivanmix.models.UploadImage;
import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadService {
    UploadImage uploadNewImage(MultipartFile file);
}
