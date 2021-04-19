package dev.jerry.service.impl;

import dev.jerry.entity.Images;
import dev.jerry.repository.ImagesRepository;
import dev.jerry.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImagesService {

    @Autowired
    private ImagesRepository imagesRepository;

    @Override
    public List<Images> getImagesByType(String imageTag) {
        return imagesRepository.getImagesByTag(imageTag);
    }

    @Override
    public Images getImageById(String imageId) {
        return imagesRepository.getImageById(imageId);
    }
}
