package dev.jerry.service;

import dev.jerry.entity.Images;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ImagesService {

    public List<Images> getImagesByType(String imageType);
}
