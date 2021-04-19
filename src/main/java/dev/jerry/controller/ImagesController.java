package dev.jerry.controller;

import dev.jerry.entity.Images;
import dev.jerry.service.impl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.List;

@RestController
@RequestMapping("/image")
public class ImagesController {

    @Autowired
    private ImageServiceImpl imageService;

    @GetMapping("/groupImages/{imageTag}")
    public List<Images> getImageUrl(@PathVariable String imageTag) {

        List<Images> images = imageService.getImagesByType(imageTag);
        for (Images image: images
             ) {
            image.setImgUrl("http://localhost:8080/image/" + image.getImageId());
        }
        return images;
    };

    @GetMapping(value = "/{imageId}", produces = {MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
    public BufferedImage getImageById(@PathVariable String imageId) throws Exception{

        Images image = imageService.getImageById(imageId);
        String imagePath = "/images/" + image.getTag() + "/" + image.getImgName();

        Resource imgResource = new ClassPathResource(imagePath);
        return ImageIO.read(imgResource.getInputStream());
    }
}
