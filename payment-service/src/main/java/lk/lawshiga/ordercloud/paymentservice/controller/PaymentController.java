package lk.lawshiga.ordercloud.paymentservice.controller;

import lk.lawshiga.ordercloud.paymentservice.model.Response;
import lk.lawshiga.ordercloud.paymentservice.model.SimpleResponse;
import lk.lawshiga.ordercloud.paymentservice.service.PaymentService;
import lk.lawshiga.ordercloud.model.payment.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/services/payments")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping
    public Payment save(@RequestBody Payment payment) {
        return paymentService.save(payment);
    }

    @GetMapping(value = "/{id}")
    public Response getPayment(@PathVariable int id, @RequestParam(required = false) String type) throws ExecutionException, InterruptedException {
        if(type==null) {
            return new SimpleResponse(paymentService.findById(id));
        } else {
            return paymentService.findDetailResponse(id);
        }
    }

    @GetMapping
    public List<Payment> getAllPayments(){
        return paymentService.findAll();
    }
}
