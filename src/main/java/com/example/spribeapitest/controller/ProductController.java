package com.example.spribeapitest.controller;

import com.example.spribeapitest.dto.request.ProductRequestDto;
import com.example.spribeapitest.dto.response.ProductResponseDto;
import com.example.spribeapitest.model.Product;
import com.example.spribeapitest.service.ProductService;
import com.example.spribeapitest.service.mapper.ProductMapper;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService,
                             ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping
    public ProductResponseDto add(@RequestBody @Valid ProductRequestDto requestDto) {
        Product product = productMapper.mapToModel(requestDto);
        Product savedProduct = productService.add(product);
        return productMapper.mapToDto(savedProduct);
    }

    @PutMapping("/{id}")
    public ProductResponseDto update(@PathVariable Long id,
                                     @RequestBody @Valid ProductRequestDto requestDto) {
        Product product = productMapper.mapToModel(requestDto);
        product.setId(id);
        Product updatedProduct = productService.update(product);
        return productMapper.mapToDto(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
