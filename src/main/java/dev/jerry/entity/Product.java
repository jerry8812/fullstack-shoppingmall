package dev.jerry.entity;

import lombok.Data;

@Data
public class Product {
    private String productId;
    private String productName;
    private String description;
    private Double price;
    private Double oldPrice;
    private String brand;
    private String tag;
    private String imageId;
    private Integer instock;
    private String categoryId;

    private transient String imgUrl;
}
