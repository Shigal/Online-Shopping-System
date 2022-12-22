package lk.lawshiga.ordercloud.paymentservice.hystrix;


import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import lk.lawshiga.ordercloud.model.order.Order;
import org.springframework.web.client.RestTemplate;

public class OrderCommand extends HystrixCommand<Order> {

    RestTemplate restTemplate;
    int orderId;

    public OrderCommand(RestTemplate restTemplate, int orderId) {
        super(HystrixCommandGroupKey.Factory.asKey("default"));
        this.restTemplate = restTemplate;
        this.orderId = orderId;
    }

    @Override
    protected Order run() throws Exception {
        return restTemplate.getForObject("http://order/services/orders/" + orderId, Order.class);
    }

    @Override
    protected Order getFallback() {
        System.out.println("hit on fallback");
        return new Order();
    }

}
