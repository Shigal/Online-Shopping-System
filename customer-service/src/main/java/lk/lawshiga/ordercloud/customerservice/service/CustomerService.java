package lk.lawshiga.ordercloud.customerservice.service;

import lk.lawshiga.ordercloud.model.customer.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);
    Customer findById(int id);
    List<Customer> findAll();

}
