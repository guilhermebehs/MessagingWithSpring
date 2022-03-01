package br.com.guilherme.behs.messaging.adapter.in.messaging;

import br.com.guilherme.behs.messaging.entity.OrderStatusChanged;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Profile("prod")
@Component
public class ServiceBusConsumerAdapter {

    @JmsListener(destination = "order-status-changed", containerFactory = "topicJmsListenerContainerFactory",
            subscription = "guilherme-subs")
    public void receive(OrderStatusChanged orderStatusChanged){
        System.out.println("received "+orderStatusChanged);
    }
}
