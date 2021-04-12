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

@RestController
@RequestMapping("/images")
public class ImagesController {

    @Autowired
    private ImageServiceImpl imageService;

    @GetMapping("/{imageType}")
    public List<String> getImageUrl(@PathVariable String imageType) {

        List<String> imgUrls = new ArrayList<String>();
        List<Images> allImages = imageService.getImagesByType(imageType);

        for (Images image: allImages
             ) {
            String imgUrl = "http://localhost:8080/image/" + image.getImgType() + "/" + image.getImgName();
            imgUrls.add(imgUrl);
        }
        return imgUrls;
    }
}
