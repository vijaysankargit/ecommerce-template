package com.squareshift.ecommerce.controller;


import com.squareshift.ecommerce.dto.CartEmptyResponseDto;
import com.squareshift.ecommerce.dto.CheckoutItemsDto;
import com.squareshift.ecommerce.model.CartItems;
import com.squareshift.ecommerce.model.Item;
import com.squareshift.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    @Autowired
    CartService cartService;

    //Add Item to Cart API
    @PostMapping(value = "/v1/cart/item")
    public void addItemToCart(@RequestBody Item item) throws Exception{
        cartService.addItemToCart(item);
    }

    //Get All Items in Cart API
    @GetMapping(value = "/v1/cart/items")
    public CartItems getAllCartItems() throws Exception{
        return cartService.getAllCartItems();
    }

    //Calculate Total Value of Items in Cart API
    @GetMapping(value = "/v1/cart/checkout-value/{postalCode}")
    public CheckoutItemsDto getCheckoutValue(@PathVariable Long postalCode) throws Exception{
        return cartService.getCheckoutValue(postalCode);
    }

    //Remove All Items in cart API
    @PostMapping(value = "/v1/cart/items")
    public CartEmptyResponseDto emptyCartItems() throws Exception{
        return cartService.emptyCartItems();
    }

}
