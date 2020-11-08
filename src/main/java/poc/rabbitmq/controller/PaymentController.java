package poc.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poc.rabbitmq.controller.request.PaymentRequest;
import poc.rabbitmq.mapper.PaymentMapper;
import poc.rabbitmq.model.Payment;
import poc.rabbitmq.service.PaymentPublisherService;
@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private PaymentPublisherService paymentPublisherService;
    private PaymentMapper paymentMapper;

    @Autowired
    public PaymentController(PaymentPublisherService paymentPublisherService, PaymentMapper paymentMapper) {
        this.paymentPublisherService = paymentPublisherService;
        this.paymentMapper = paymentMapper;
    }

    @PostMapping
    public ResponseEntity<Boolean> schedulePayment(@RequestBody PaymentRequest paymentRequest) {
        Payment paymentToSchedule = paymentMapper.toPaymentModel(paymentRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(paymentPublisherService.schedulePayment(paymentToSchedule));
    }

}
