package dev.jerry.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dev.jerry.entity.Product;
import dev.jerry.entity.query.ProductQuery;
import dev.jerry.repository.ProductRepository;
import dev.jerry.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public PageInfo<Product> getProductsByTag(ProductQuery productQuery) {
        PageHelper.startPage(productQuery.getPageNum(), productQuery.getPageSize());
        return new PageInfo<Product>(productRepository.getProductsByTag(productQuery));
    }
}
