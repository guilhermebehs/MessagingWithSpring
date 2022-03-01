package br.com.guilherme.behs.messaging.port.out;

import br.com.guilherme.behs.messaging.entity.OrderStatusChanged;

public interface PublisherAdapter {
    public void send(OrderStatusChanged orderStatusChanged);
}
