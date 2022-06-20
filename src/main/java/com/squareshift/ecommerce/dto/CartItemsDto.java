package com.squareshift.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.squareshift.ecommerce.model.Item;
import lombok.Data;

import java.util.List;

@Data
public class CartItemsDto {
    private String status;

    private String message;

    @JsonProperty(value = "item")
    private List<Item> items;
}
