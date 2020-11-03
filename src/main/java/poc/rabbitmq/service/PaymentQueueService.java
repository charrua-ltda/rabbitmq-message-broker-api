package poc.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import poc.rabbitmq.model.Payment;

import static java.util.Objects.*;

@Service
public class PaymentQueueService {

    private RabbitTemplate rabbitTemplate;

    public PaymentQueueService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void schedulePayment(Payment payment) {
        if (nonNull(payment)) {
            System.out.println("Scheduling payment: " + payment);
        }
    }

}
