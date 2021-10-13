package com.example.demo.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CreateOrder {

    private String description;
    private Long consumerId;
    private Long productId;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "CreateOrder{" +
                "description='" + description + '\'' +
                ", consumerId=" + consumerId +
                ", productId=" + productId +
                '}';
    }
}
