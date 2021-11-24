package com.example.spribeapitest.service;

import com.example.spribeapitest.model.Product;

public interface ProductService {
    Product add(Product product);

    Product get(Long id);

    Product update(Product product);

    void delete(Long id);
}
