package lk.lawshiga.ordercloud.orderservice.repository;

import lk.lawshiga.ordercloud.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
