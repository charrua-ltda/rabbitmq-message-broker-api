# rabbitmq-message-broker-api
A Spring Boot API integrated with RabbitMQ message broker to deal with message objects.

###Prerequisites
1. You must have RabbitMQ server installed in your local machine. See: https://www.rabbitmq.com/download.html
2. It's extremely recommended use Postman to send HTTP requests for the API. See: https://www.postman.com

### To Execute
1. Clone this repository;
2. In the root project directory, run ```mvn spring-boot:run``` to start the application;

### To Use
After doing the above steps:
1. Send a HTTP POST request to: http://localhost:8080/payment-api/api/v1/payments, using the following Request Body:

```
{
    "description": "Product description",
    "option": "CREDIT_CARD",
    "price": 1000,
    "quantity": 10
}
```

###Result
- After doing the above steps, the message will be in RabbitMQ and managed by it (waiting for consumers).
- You can check it accessing the management and monitoring RabbitMQ interface: http://localhost:15672/ (the default username/password is "guest" for the both).
- To access the management and monitoring interface, see these rules: https://www.rabbitmq.com/management.html


