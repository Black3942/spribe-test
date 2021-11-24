package com.example.spribeapitest.dao;

import com.example.spribeapitest.model.Order;
import com.example.spribeapitest.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
