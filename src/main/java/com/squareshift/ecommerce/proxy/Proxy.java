package com.squareshift.ecommerce.proxy;

import com.squareshift.ecommerce.dto.*;
import com.squareshift.ecommerce.model.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(value = "client", url = "${external.system-service.url}")
public interface Proxy {

    @GetMapping(value = "/product/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponseDto getProductById(@PathVariable Long id) throws Exception;

    @GetMapping(value = "/warehouse/distance", consumes = MediaType.APPLICATION_JSON_VALUE)
    public WarehouseResponseDto getWareHouseDistanceByPostalCode(@RequestParam Long postal_code) throws Exception;

    @PostMapping(value = "/cart/item", produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemDto insertItemToCart(Item item) throws Exception;

    @GetMapping(value = "/card/items", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CartItemsDto getAllCardItems() throws Exception;

    @DeleteMapping(value = "/card/items")
    public CartEmptyResponseDto emptyCartItems() throws Exception;
}
