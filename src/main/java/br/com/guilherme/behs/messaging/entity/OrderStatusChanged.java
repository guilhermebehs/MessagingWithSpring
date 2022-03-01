package br.com.guilherme.behs.messaging.entity;

import com.fasterxml.jackson.annotation.JsonProperty;


public class OrderStatusChanged{

    @JsonProperty("id")
    private String id;
    @JsonProperty("status")
    private OrderStatus status;

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
