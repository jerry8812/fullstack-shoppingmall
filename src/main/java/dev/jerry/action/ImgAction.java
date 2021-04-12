package dev.jerry.action;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/image")
public class ImgAction {


    @GetMapping(value = "/{imageType}/{imageName}", produces = {MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
    public BufferedImage createImgData(@PathVariable("imageName") String imageName,
                                       @PathVariable("imageType") String imageType) throws Exception {

//        Resource imgResource = new ClassPathResource("/images/banner/banner01.jpg");
        String imagePath = "/images/" + imageType + "/" + imageName;
        Resource imgResource = new ClassPathResource(imagePath);

        return ImageIO.read(imgResource.getInputStream());
    }
}
