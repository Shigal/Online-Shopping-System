package lk.lawshiga.ordercloud.customerservice.controller;

import lk.lawshiga.ordercloud.customerservice.service.CustomerService;
import lk.lawshiga.ordercloud.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/services/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping(value = "/{id}")
    public Customer getCustomer(@PathVariable int id) {
        System.out.println("<---------- request came on " + LocalDateTime.now() + "------3------>");
        return customerService.findById(id);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }
}
