package poc.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import poc.rabbitmq.enumeration.PaymentOption;
import poc.rabbitmq.enumeration.PaymentStatus;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private String id;
    private String description;
    private PaymentOption option;
    private BigDecimal price;
    private Integer quantity;
    private PaymentStatus status;

}
