package lk.lawshiga.ordercloud.orderservice.service;

import lk.lawshiga.ordercloud.orderservice.repository.OrderRepository;
import lk.lawshiga.ordercloud.model.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order findById(int id) {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent()) {
            return order.get();
        }
        else {
            return new Order();
        }
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
