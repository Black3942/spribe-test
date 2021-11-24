package com.example.spribeapitest.dao;

import com.example.spribeapitest.model.ShoppingCart;
import com.example.spribeapitest.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    ShoppingCart update(ShoppingCart shoppingCart);
}
