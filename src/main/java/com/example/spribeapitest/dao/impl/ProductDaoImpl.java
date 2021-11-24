package com.example.spribeapitest.dao.impl;

import com.example.spribeapitest.dao.AbstractDao;
import com.example.spribeapitest.dao.ProductDao;
import com.example.spribeapitest.model.Product;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl extends AbstractDao<Product> implements ProductDao {
    public ProductDaoImpl(SessionFactory factory) {
        super(factory, Product.class);
    }
}
