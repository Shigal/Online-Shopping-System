package lk.lawshiga.ordercloud.paymentservice.model;

import lk.lawshiga.ordercloud.model.payment.Payment;

public class SimpleResponse implements Response{

    Payment payment;

    public SimpleResponse(Payment payment) {
        this.payment = payment;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
