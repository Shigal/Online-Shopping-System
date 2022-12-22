package lk.lawshiga.ordercloud.orderservice.controller;

import lk.lawshiga.ordercloud.orderservice.service.OrderService;
import lk.lawshiga.ordercloud.model.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/services/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public Order save(@RequestBody Order order){
        return orderService.save(order);
    }

    @GetMapping(value = "/{id}")
    public Order getOrder(@PathVariable int id){
        System.out.println("<------------request came on " + LocalDateTime.now() + "----------->");
        return orderService.findById(id);
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.findAll();
    }
}
