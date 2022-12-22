package lk.lawshiga.ordercloud.orderservice.service;

import lk.lawshiga.ordercloud.model.order.Order;

import java.util.List;

public interface OrderService {
    Order save(Order order);

    Order findById(int id);

    List<Order> findAll();
}
