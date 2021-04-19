package dev.jerry.repository;

import dev.jerry.entity.Product;
import dev.jerry.entity.query.ProductQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductRepository {
    public List<Product> getProductsByTag(ProductQuery productQuery);
}
