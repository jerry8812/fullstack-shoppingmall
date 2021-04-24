package dev.jerry.controller;

import dev.jerry.common.CommonResult;
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
@RequestMapping("/images")
public class ImagesController {

    @Autowired
    private ImageServiceImpl imageService;

    @GetMapping("/groupImages/{imageTag}")
    public CommonResult<List<Images>> getImageUrl(@PathVariable String imageTag) {

        List<Images> imagesList = imageService.getImagesByType(imageTag);
        return CommonResult.success(imagesList);
    };

    @GetMapping(value = "/{imageId}", produces = {MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
    public BufferedImage getImageById(@PathVariable String imageId) throws Exception{

        Images image = imageService.getImageById(imageId);
        String imagePath = "/images/" + image.getTag() + "/" + image.getImgName();

        Resource imgResource = new ClassPathResource(imagePath);
        BufferedImage bufferedImage = ImageIO.read(imgResource.getInputStream());
        return bufferedImage;
    }
}
