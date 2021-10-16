package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table
public class ProductV2 {

    @Id
    @Column(name = "productv2_id")
    @SequenceGenerator(
            name = "productv2_sequence",
            sequenceName = "productv2_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "productv2_sequence"
    )
    private Long id;

    @NotBlank(message = "description must exist")
    private String description;

    @NotBlank(message = "category must exist")
    private String category;

    @Min(value = 1, message = "Price must be at least 1")
    private int price;

    @OneToMany(mappedBy = "productv2")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PurchaseOrder> orders;

    public ProductV2 () {}

    public ProductV2(Long id, String description, String category, int price) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public ProductV2(String description, String category, int price) {
        this.description = description;
        this.category = category;
        this.price = price;
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

    public void setDescription(String desc) {
        this.description = desc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String cat) {
        this.description = cat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @JsonBackReference
    public List<PurchaseOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<PurchaseOrder> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", desc='" + description + '\'' +
                ", cat='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}

