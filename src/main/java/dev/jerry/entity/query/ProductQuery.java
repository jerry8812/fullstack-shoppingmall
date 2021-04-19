package dev.jerry.entity.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductQuery {
    private Integer pageNum = 1;
    private Integer pageSize = 1;
    private String productTag;
}
