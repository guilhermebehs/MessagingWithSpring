package br.com.guilherme.behs.messaging.adapter.out.data;

import br.com.guilherme.behs.messaging.entity.OrderStatusChanged;
import org.springframework.stereotype.Component;

@Component
public class DataSourceAdapter {
    private final MongoDataSourceRepository mongoDataSourceRepository;

    public DataSourceAdapter(MongoDataSourceRepository mongoDataSourceRepository) {
        this.mongoDataSourceRepository = mongoDataSourceRepository;
    }

    public OrderStatusChanged insert(OrderStatusChanged orderStatusChanged){
        mongoDataSourceRepository.insert(orderStatusChanged);
        return orderStatusChanged;
    }
}
