package com.example.spribeapitest.service.impl;

import com.example.spribeapitest.dao.ProductDao;
import com.example.spribeapitest.dao.ShoppingCartDao;
import com.example.spribeapitest.model.Product;
import com.example.spribeapitest.model.ShoppingCart;
import com.example.spribeapitest.model.User;
import com.example.spribeapitest.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartDao shoppingCartDao;
    private final ProductDao productDao;

    public ShoppingCartServiceImpl(ShoppingCartDao shoppingCartDao, ProductDao productDao) {
        this.shoppingCartDao = shoppingCartDao;
        this.productDao = productDao;
    }

    @Override
    public void addProduct(Product product, User user, int amount) {
        if (!(product.getAmount() == 0)  && amount > 0 && product.getAmount() >= amount) {
            ShoppingCart shoppingCart = shoppingCartDao.getByUser(user);
            product.setAmount(product.getAmount() - amount);
            productDao.update(product);
            shoppingCart.getProducts().add(product);
            shoppingCartDao.update(shoppingCart);
        }
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartDao.getByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartDao.add(shoppingCart);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.setProducts(null);
        shoppingCartDao.update(shoppingCart);
    }
}
