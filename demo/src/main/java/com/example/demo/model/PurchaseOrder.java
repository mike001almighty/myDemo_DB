package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table
public class PurchaseOrder {

    @Id
    @SequenceGenerator(
            name = "purchaseOrder_sequence",
            sequenceName = "purchaseOrder_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "purchaseOrder_sequence"
    )
    private Long id;
    private String description;

    @ManyToOne
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public PurchaseOrder() {}

    public PurchaseOrder(Long id, String description, Consumer consumer, Product product ) {
        this.id = id;
        this.description = description;
        this.consumer = consumer;
        this.product = product;
    }

    public PurchaseOrder(String description, Consumer consumer, Product product) {
        this.description = description;
        this.consumer = consumer;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", consumer=" + consumer +
                ", product=" + product +
                '}';
    }
}
