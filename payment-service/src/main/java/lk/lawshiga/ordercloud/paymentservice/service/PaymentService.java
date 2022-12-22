package lk.lawshiga.ordercloud.paymentservice.service;

import lk.lawshiga.ordercloud.paymentservice.model.DetailResponse;
import lk.lawshiga.ordercloud.model.payment.Payment;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface PaymentService {
    Payment save(Payment payment);

    Payment findById(int id);
    
    List<Payment> findAll();

    DetailResponse findDetailResponse(int id) throws ExecutionException, InterruptedException;
}
