package poc.rabbitmq.mapper;

import org.springframework.stereotype.Component;
import poc.rabbitmq.controller.request.PaymentRequest;
import poc.rabbitmq.enumeration.PaymentStatus;
import poc.rabbitmq.model.Payment;

import java.util.UUID;

@Component
public class PaymentMapper {

    public Payment toPaymentModel(PaymentRequest paymentRequest) {
        return Payment.builder()
                .id(UUID.randomUUID().toString())
                .description(paymentRequest.getDescription())
                .option(paymentRequest.getOption())
                .price(paymentRequest.getPrice())
                .quantity(paymentRequest.getQuantity())
                .status(PaymentStatus.ACTIVE)
                .build();
        }

}
