package com.example.spribeapitest.service.mapper;

import com.example.spribeapitest.dto.request.ProductRequestDto;
import com.example.spribeapitest.dto.response.ProductResponseDto;
import com.example.spribeapitest.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements RequestDtoMapper<ProductRequestDto, Product>,
        ResponseDtoMapper<ProductResponseDto, Product> {

    @Override
    public Product mapToModel(ProductRequestDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setWeight(dto.getWeight());
        product.setPrice(dto.getPrice());
        return product;
    }

    @Override
    public ProductResponseDto mapToDto(Product product) {
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setName(product.getName());
        responseDto.setWeight(product.getWeight());
        responseDto.setPrice(product.getPrice());
        return responseDto;
    }
}
