package br.com.guilherme.behs.messaging.adapter.out.data;

import br.com.guilherme.behs.messaging.entity.OrderStatusChanged;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDataSourceRepository extends MongoRepository<OrderStatusChanged, String> {
}
