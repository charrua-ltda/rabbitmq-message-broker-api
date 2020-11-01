package poc.rabbitmq.controller.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import poc.rabbitmq.enumeration.PaymentOption;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String description;
    private PaymentOption option;
    private BigDecimal price;
    private int quantity;

}
