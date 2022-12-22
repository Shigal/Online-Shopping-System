package lk.lawshiga.ordercloud.paymentservice.service;

import com.netflix.hystrix.HystrixCommand;
import lk.lawshiga.ordercloud.paymentservice.hystrix.CommonHystrixCommand;
import lk.lawshiga.ordercloud.paymentservice.hystrix.OrderCommand;
import lk.lawshiga.ordercloud.paymentservice.repository.PaymentRepository;
import lk.lawshiga.ordercloud.paymentservice.model.DetailResponse;
import lk.lawshiga.ordercloud.model.customer.Customer;
import lk.lawshiga.ordercloud.model.order.Order;
import lk.lawshiga.ordercloud.model.payment.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    HystrixCommand.Setter setter;

    @LoadBalanced
    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment findById(int id) {
        Optional<Payment> paymentOptional = paymentRepository.findById(id);
        if(paymentOptional.isPresent()) {
            return paymentOptional.get();
        } else {
            return new Payment();
        }
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public DetailResponse findDetailResponse(int id) throws ExecutionException, InterruptedException {
        Payment payment = findById(id);
        Customer customer = getCustomer(payment.getCustomerId());
        Order order = getOrder(payment.getOrderId());

        return new DetailResponse(payment, customer, order);
    }

    private Customer getCustomer(int customerId) throws ExecutionException, InterruptedException {
        CommonHystrixCommand<Customer> commonHystrixCommand = new CommonHystrixCommand<Customer>(setter, ()->{
            return restTemplate.getForObject("http://customer/services/customers/" + customerId, Customer.class);
        }, () -> {
            return new Customer();
        });
        Future<Customer> customerFuture = commonHystrixCommand.queue();
        return customerFuture.get();
    }

    private Order getOrder(int orderId) {
        OrderCommand orderCommand = new OrderCommand(restTemplate, orderId);
        return orderCommand.execute();
//        return restTemplate.getForObject("http://order/services/orders/" + orderId, Order.class);
    }
}
