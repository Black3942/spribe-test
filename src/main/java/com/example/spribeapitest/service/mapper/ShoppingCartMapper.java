package com.example.spribeapitest.service.mapper;

import com.example.spribeapitest.dto.response.ShoppingCartResponseDto;
import com.example.spribeapitest.model.Product;
import com.example.spribeapitest.model.ShoppingCart;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper implements
        ResponseDtoMapper<ShoppingCartResponseDto, ShoppingCart> {

    @Override
    public ShoppingCartResponseDto mapToDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setUserId(shoppingCart.getUser().getId());
        responseDto.setProductIds(shoppingCart.getProducts()
                .stream()
                .map(Product::getId)
                .collect(Collectors.toList()));
        return responseDto;
    }
}
