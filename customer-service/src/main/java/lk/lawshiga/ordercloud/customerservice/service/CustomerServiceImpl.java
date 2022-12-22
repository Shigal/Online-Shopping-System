package lk.lawshiga.ordercloud.customerservice.service;

import lk.lawshiga.ordercloud.customerservice.repository.CustomerRepository;
import lk.lawshiga.ordercloud.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(int customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if(customer.isPresent()) {
            return customer.get();
        } else {
            return new Customer();
        }
    }

    @Override
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
}
