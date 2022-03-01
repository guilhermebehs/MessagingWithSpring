package br.com.guilherme.behs.messaging.adapter.out.messaging;

import br.com.guilherme.behs.messaging.entity.OrderStatusChanged;
import br.com.guilherme.behs.messaging.port.out.PublisherAdapter;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!prod")
public class RabbitMqPublisherAdapter implements PublisherAdapter {

    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange exchange;

    public RabbitMqPublisherAdapter(RabbitTemplate rabbitTemplate, DirectExchange exchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
    }

    @Override
    public void send(OrderStatusChanged orderStatusChanged) {
        String routingKey = "rk-order-status";
        rabbitTemplate.convertAndSend(exchange.getName(),routingKey, orderStatusChanged);
    }
}
