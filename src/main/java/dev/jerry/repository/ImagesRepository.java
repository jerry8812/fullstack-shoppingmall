package dev.jerry.repository;

import dev.jerry.entity.Images;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ImagesRepository {

    public List<Images> getImagesByType(String type);


}
