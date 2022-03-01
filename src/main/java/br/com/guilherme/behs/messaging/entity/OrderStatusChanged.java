package br.com.guilherme.behs.messaging.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document("events")
public class OrderStatusChanged {

    @JsonProperty("id")
    @Field("order_id")
    private String id;

    @JsonProperty("status")
    private OrderStatus status;

    @CreatedDate
    private DateTime createdDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "OrderStatusChanged{" +
                "id='" + id + '\'' +
                ", status=" + status +
                '}';
    }
}
