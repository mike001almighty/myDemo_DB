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
    @JoinColumn(name = "productv2_id")
    private ProductV2 product;

//    @ManyToOne
//    @JoinColumn(name = "productv2_id")
//    private ProductV2 productv2;

    public PurchaseOrder() {}

    public PurchaseOrder(Long id, String description, Consumer consumer, ProductV2 product/*, ProductV2 productV2*/) {
        this.id = id;
        this.description = description;
        this.consumer = consumer;
        this.product = product;
//        this.productv2 = productV2;
    }

    public PurchaseOrder(String description, Consumer consumer, ProductV2 product/*, ProductV2 productV2*/) {
        this.description = description;
        this.consumer = consumer;
        this.product = product;
//        this.productv2 = productV2;
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

    public ProductV2 getProduct() { return product; }

    public void setProduct(ProductV2 product) { this.product = product; }

//    public ProductV2 getProductV2() { return productv2; }
//
//    public void setProductV2(ProductV2 productV2) { this.productv2 = productV2; }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", consumer=" + consumer +
                ", product=" + product +
//                ", productV2=" + productv2 +
                '}';
    }
}
