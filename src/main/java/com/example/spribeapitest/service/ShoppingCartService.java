package com.example.spribeapitest.service;

import com.example.spribeapitest.model.Product;
import com.example.spribeapitest.model.ShoppingCart;
import com.example.spribeapitest.model.User;

public interface ShoppingCartService {
    void addProduct(Product product, User user, int amount);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
