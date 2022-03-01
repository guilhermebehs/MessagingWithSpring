package br.com.guilherme.behs.messaging.adapter.in.messaging;
import br.com.guilherme.behs.messaging.entity.OrderStatusChanged;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Profile("!prod")
@Component
public class RabbitMqConsumerAdapter {

    @RabbitListener(queues = "order-status-changed")
    public void receive(@Payload OrderStatusChanged orderStatusChanged){
        System.out.println("Received "+orderStatusChanged);
    }
}
