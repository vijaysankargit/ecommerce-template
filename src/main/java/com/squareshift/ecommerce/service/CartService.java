package com.squareshift.ecommerce.service;

import com.squareshift.ecommerce.dto.CartEmptyResponseDto;
import com.squareshift.ecommerce.dto.CheckoutItemsDto;
import com.squareshift.ecommerce.model.CartItems;
import com.squareshift.ecommerce.model.Item;

public interface CartService {
    void addItemToCart(Item item) throws Exception;

    CartItems getAllCartItems() throws Exception;

    CartEmptyResponseDto emptyCartItems() throws Exception;

    CheckoutItemsDto getCheckoutValue(Long postalCode) throws Exception;
}
