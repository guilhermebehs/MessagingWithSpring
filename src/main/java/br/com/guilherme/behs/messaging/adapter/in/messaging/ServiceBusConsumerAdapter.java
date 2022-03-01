package br.com.guilherme.behs.messaging.adapter.in.messaging;

import br.com.guilherme.behs.messaging.adapter.out.data.DataSourceAdapter;
import br.com.guilherme.behs.messaging.entity.OrderStatusChanged;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Profile("prod")
@Component
public class ServiceBusConsumerAdapter {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(RabbitMqConsumerAdapter.class);

    private final DataSourceAdapter dataSourceAdapter;

    public ServiceBusConsumerAdapter(DataSourceAdapter dataSourceAdapter) {
        this.dataSourceAdapter = dataSourceAdapter;
    }


    @JmsListener(destination = "order-status-changed", containerFactory = "topicJmsListenerContainerFactory",
            subscription = "guilherme-subs")
    public void receive(OrderStatusChanged orderStatusChanged){
        LOGGER.info("Receiving data {}", orderStatusChanged);
        dataSourceAdapter.insert(orderStatusChanged);
    }
}
