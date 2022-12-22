package lk.lawshiga.ordercloud.paymentservice.model;

import lk.lawshiga.ordercloud.model.customer.Customer;
import lk.lawshiga.ordercloud.model.order.Order;
import lk.lawshiga.ordercloud.model.payment.Payment;

public class DetailResponse implements Response{

    Payment payment;
    Customer customer;
    Order order;

    public DetailResponse(Payment payment, Customer customer, Order order) {
        this.payment = payment;
        this.customer = customer;
        this.order = order;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
