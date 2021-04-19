package dev.jerry.service;

import com.github.pagehelper.PageInfo;
import dev.jerry.entity.Product;
import dev.jerry.entity.query.ProductQuery;

import java.util.List;

public interface ProductService {
    public PageInfo<Product> getProductsByTag(ProductQuery productQuery);
}
