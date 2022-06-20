package com.squareshift.ecommerce.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class CartItems {

    private String status;

    private String message;

    private List<Item> items;
}
