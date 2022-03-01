package br.com.guilherme.behs.messaging.adapter.out.messaging;

import br.com.guilherme.behs.messaging.entity.OrderStatusChanged;
import br.com.guilherme.behs.messaging.port.out.PublisherAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ServiceBusPublisherAdapter implements PublisherAdapter {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(OrderStatusChanged orderStatusChanged){
        jmsTemplate.convertAndSend("order-status-changed", orderStatusChanged);

    }
}
