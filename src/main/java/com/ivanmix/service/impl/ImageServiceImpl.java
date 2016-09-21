package com.ivanmix.service.impl;

import com.ivanmix.entity.Image;
import com.ivanmix.entity.Project;
import com.ivanmix.entity.User;
import com.ivanmix.models.UploadImage;
import com.ivanmix.repository.ImageRepository;
import com.ivanmix.repository.ProjectRepository;
import com.ivanmix.repository.UserRepository;
import com.ivanmix.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addImage(Long userId, Long projectId, UploadImage uploadImage) {
        Project project = projectRepository.findById(projectId);
        User user = userRepository.findById(userId);
        Image image = new Image();
        image.setBig(uploadImage.getBigImage());
        image.setSmall(uploadImage.getSmallImage());
        image.setProject(project);
        image.setUser(user);
        imageRepository.save(image);
    }
}