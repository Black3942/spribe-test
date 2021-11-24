package com.example.spribeapitest.service.impl;

import com.example.spribeapitest.dao.ProductDao;
import com.example.spribeapitest.exception.DataProcessingException;
import com.example.spribeapitest.model.Product;
import com.example.spribeapitest.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product add(Product product) {
        return productDao.add(product);
    }

    @Override
    public Product get(Long id) {
        return productDao.get(id).orElseThrow(() ->
                new DataProcessingException("Product with id " + id + " not found"));
    }

    @Override
    public Product update(Product product) {
        return productDao.update(product);
    }

    @Override
    public void delete(Long id) {
        productDao.delete(id);
    }
}
