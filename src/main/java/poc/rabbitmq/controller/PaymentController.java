package poc.rabbitmq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poc.rabbitmq.controller.request.PaymentRequest;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private RabbitTemplate template;

    @Autowired
    public PaymentController(RabbitTemplate template) {
        this.template = template;
    }

    @PostMapping
    public ResponseEntity<Boolean> doPayment(@RequestBody PaymentRequest paymentRequest) {
        System.out.println(paymentRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Boolean.TRUE);
    }

}
