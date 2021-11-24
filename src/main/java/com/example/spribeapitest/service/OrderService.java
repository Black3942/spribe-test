package com.example.spribeapitest.service;

import com.example.spribeapitest.model.Order;
import com.example.spribeapitest.model.ShoppingCart;
import com.example.spribeapitest.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
