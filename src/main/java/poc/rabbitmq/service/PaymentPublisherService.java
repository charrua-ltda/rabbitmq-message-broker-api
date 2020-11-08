package poc.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import poc.rabbitmq.model.Payment;

import static java.util.Objects.*;

@Service
public class PaymentPublisherService {

    @Value("${message-queuing.queue}")
    private String queue;

    @Value("${message-queuing.exchange}")
    private String exchange;

    @Value("${message-queuing.routing-key}")
    private String routingKey;

    private RabbitTemplate rabbitTemplate;

    public PaymentPublisherService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public boolean schedulePayment(Payment payment) {
        boolean paymentScheduled = false;
        if (nonNull(payment)) {
            rabbitTemplate.convertAndSend(exchange, routingKey, payment);
            paymentScheduled = true;
        }
        return paymentScheduled;
    }

}
