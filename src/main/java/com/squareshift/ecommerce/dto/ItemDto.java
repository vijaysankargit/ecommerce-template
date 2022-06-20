package com.squareshift.ecommerce.dto;

import lombok.Data;

@Data
public class ItemDto {
    private Integer productId;

    private String description;

    private Long quantity;
}
