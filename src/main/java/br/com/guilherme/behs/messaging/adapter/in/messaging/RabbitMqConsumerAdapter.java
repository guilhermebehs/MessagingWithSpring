package br.com.guilherme.behs.messaging.adapter.in.messaging;
import br.com.guilherme.behs.messaging.adapter.out.data.DataSourceAdapter;
import br.com.guilherme.behs.messaging.entity.OrderStatusChanged;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Profile("!prod")
@Component
public class RabbitMqConsumerAdapter {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(RabbitMqConsumerAdapter.class);

    private final DataSourceAdapter dataSourceAdapter;

    public RabbitMqConsumerAdapter(DataSourceAdapter dataSourceAdapter) {
        this.dataSourceAdapter = dataSourceAdapter;
    }

    @RabbitListener(queues = "order-status-changed")
    public void receive(@Payload OrderStatusChanged orderStatusChanged){
        LOGGER.info("Receiving data {}", orderStatusChanged);
        dataSourceAdapter.insert(orderStatusChanged);
    }
}
