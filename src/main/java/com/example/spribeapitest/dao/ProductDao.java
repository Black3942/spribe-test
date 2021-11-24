package com.example.spribeapitest.dao;

import com.example.spribeapitest.model.Product;
import java.util.Optional;

public interface ProductDao {
    Product add(Product product);

    Optional<Product> get(Long id);

    Product update(Product product);

    void delete(Long id);
}
