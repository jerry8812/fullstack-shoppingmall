package dev.jerry.controller;

import com.github.pagehelper.PageInfo;
import dev.jerry.entity.Product;
import dev.jerry.entity.query.ProductQuery;
import dev.jerry.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/tag")
    public PageInfo<Product> getProductsByTag(@RequestParam("productTag") String productTag,
                                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                              @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize,
                                              ProductQuery productQuery){
        productQuery.setProductTag(productTag);
        productQuery.setPageSize(pageSize);
        productQuery.setPageNum(pageNum);

        return productService.getProductsByTag(productQuery);
    }
}
