package dev.jerry.controller;

import dev.jerry.entity.Images;
import dev.jerry.service.impl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/images")
public class ImagesController {

    @Autowired
    private ImageServiceImpl imageService;

    @GetMapping("/{imageType}")
    public List<Images> getImageUrl(@PathVariable String imageType) {

        List<Images> allImages = imageService.getImagesByType(imageType);

        for (Images image: allImages
             ) {
            String imgUrl = "http://localhost:8080/image/" + image.getImgType() + "/" + image.getImgName();
            image.setUrl(imgUrl);
        }
        return allImages;
    }
}
