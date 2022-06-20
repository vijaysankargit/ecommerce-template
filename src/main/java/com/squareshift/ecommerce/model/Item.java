package com.squareshift.ecommerce.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {

    private Integer productId;

    private String description;

    private Long quantity;
}
