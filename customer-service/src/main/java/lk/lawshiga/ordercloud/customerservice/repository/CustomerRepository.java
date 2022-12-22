package lk.lawshiga.ordercloud.customerservice.repository;

import lk.lawshiga.ordercloud.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
