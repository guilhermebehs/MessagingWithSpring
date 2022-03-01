package br.com.guilherme.behs.messaging.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderStatus {

    CREATED("created"),
    IN_DELIVERY_ROUTE("in_delivery_route"),
    DELIVERED("delivered"),
    CANCELED("canceled");

    private final String value;
    OrderStatus(String value){
         this.value = value;
    }

    @JsonValue
    public String getValue(){
        return value;
    }
}
