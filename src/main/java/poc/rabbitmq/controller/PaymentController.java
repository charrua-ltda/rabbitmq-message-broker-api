package poc.rabbitmq.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poc.rabbitmq.controller.request.PaymentRequest;
import poc.rabbitmq.enumeration.PaymentStatus;
import poc.rabbitmq.model.Payment;
import poc.rabbitmq.service.PaymentQueueService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private PaymentQueueService paymentQueueService;

    public PaymentController(PaymentQueueService paymentQueueService) {
        this.paymentQueueService = paymentQueueService;
    }

    @PostMapping
    public ResponseEntity<Boolean> schedulePayment(@RequestBody PaymentRequest paymentRequest) {
        paymentQueueService.schedulePayment(createPayment(paymentRequest));

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Boolean.TRUE);
    }

    private Payment createPayment(@RequestBody PaymentRequest paymentRequest) {
        return Payment.builder().
                id(UUID.randomUUID().toString())
                .description(paymentRequest.getDescription())
                .option(paymentRequest.getOption())
                .price(paymentRequest.getPrice())
                .quantity(paymentRequest.getQuantity())
                .status(PaymentStatus.ACTIVE)
                .build();
    }

}
