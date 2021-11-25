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
    public synchronized Product add(Product product) {
        return productDao.add(product);
    }

    @Override
    public synchronized Product get(Long id) {
        return productDao.get(id).orElseThrow(() ->
                new DataProcessingException("Product with id " + id + " not found"));
    }

    @Override
    public synchronized Product update(Product product) {
        return productDao.update(product);
    }

    @Override
    public synchronized void delete(Long id) {
        productDao.delete(id);
    }
}
