package com.example.demo.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CreateOrder {

    private String description;
    private Long consumerId;
    private Long productId;
    private Long productv2Id;

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

    public void setProductId(Long productId) { this.productId = productId; }

    public Long getProductV2Id() {
        return productv2Id;
    }

    public void setProductV2Id(Long productv2Id) {
        this.productv2Id = productv2Id;
    }

    @Override
    public String toString() {
        return "CreateOrder{" +
                "description='" + description + '\'' +
                ", consumerId=" + consumerId +
                ", productId=" + productId +
                ", productv2Id=" + productv2Id +
                '}';
    }
}
