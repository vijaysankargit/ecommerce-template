package com.squareshift.ecommerce.service;

import com.squareshift.ecommerce.model.ShippingCost;
import com.squareshift.ecommerce.dto.*;
import com.squareshift.ecommerce.model.CartItems;
import com.squareshift.ecommerce.model.Item;
import com.squareshift.ecommerce.proxy.Proxy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    Proxy proxy;

    @Autowired
    WareHouseService wareHouseService;

    @Autowired
    ProductService productService;

    @Override
    public void addItemToCart(Item item) throws Exception{
        proxy.insertItemToCart(item);
    }

    @Override
    public CartItems getAllCartItems() throws Exception{
        CartItemsDto cartItemsDtoList =  proxy.getAllCardItems();
        CartItems cartItemsList = new CartItems();
        BeanUtils.copyProperties(cartItemsDtoList, cartItemsList);
        return cartItemsList;
    }

    @Override
    public CartEmptyResponseDto emptyCartItems() throws Exception{
        return proxy.emptyCartItems();
    }

    @Override
    public CheckoutItemsDto getCheckoutValue(Long postalCode) throws Exception{
        WarehouseResponseDto distance = wareHouseService.getWareHouseDistanceByPostalCode(postalCode);
        CartItemsDto cartItemsDtoList =  proxy.getAllCardItems();
        List<Integer> productIdList = cartItemsDtoList.getItems().stream().map(item -> item.getProductId()).collect(Collectors.toList());
        List<ProductDto> productList = productIdList.stream().map(id -> {
            try {
                return productService.getProductById(new Long(id));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
        Long totalWeightOfItems = productList.stream().map(weight -> weight.getWeight_in_grams()).collect(Collectors.summingLong(Long::longValue));
        ShippingCost shippingCost = new ShippingCost();
        int totalCheckoutValue = shippingCost.getPrice(Integer.parseInt(totalWeightOfItems.toString()), Integer.parseInt(distance.getDistance_in_kilometers().toString()));
        CheckoutItemsDto checkoutItemsDto = new CheckoutItemsDto();
        checkoutItemsDto.setStatus("success");
        checkoutItemsDto.setMessage("Total value of your shopping cart is "+ totalCheckoutValue);
        return checkoutItemsDto;
    }
}
