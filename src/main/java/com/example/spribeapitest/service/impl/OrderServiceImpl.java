package com.example.spribeapitest.service.impl;

import com.example.spribeapitest.dao.OrderDao;
import com.example.spribeapitest.model.Order;
import com.example.spribeapitest.model.ShoppingCart;
import com.example.spribeapitest.model.User;
import com.example.spribeapitest.service.OrderService;
import com.example.spribeapitest.service.ShoppingCartService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDao orderDao;
    private final ShoppingCartService shoppingCartService;

    public OrderServiceImpl(OrderDao orderDao, ShoppingCartService shoppingCartService) {
        this.orderDao = orderDao;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setOrderTime(LocalDateTime.now());
        order.setProducts(shoppingCart.getProducts());
        order.setUser(shoppingCart.getUser());
        orderDao.add(order);
        shoppingCartService.clear(shoppingCart);
        return order;
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getOrdersHistory(user);
    }
}
