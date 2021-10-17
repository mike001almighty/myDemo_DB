package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.ProductV2;
import com.example.demo.rep.ProductV2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductV2Service {

    private ProductV2Repository productV2Repository;
    @Autowired
    public ProductV2Service(ProductV2Repository productV2Repository) {
        this.productV2Repository = productV2Repository;
    }

    public List<ProductV2> getProductsV2() { return productV2Repository.findAll(); }

    public ProductV2 getProductV2ById(Long id) throws NotFoundException {
        boolean existsProductV2 = productV2Repository.existsById(id);
        if (!existsProductV2) {
            throw new NotFoundException("product with id " + id + " does not exist");
        }
        return productV2Repository.getById(id);
    }

    public void addNewProductV2(ProductV2 productv2) {
        productV2Repository.save(productv2);
        System.out.println(productv2);
    }

    public void deleteProductV2(Long productV2Id) throws NotFoundException {
        boolean existsProductV2 = productV2Repository.existsById(productV2Id);
        if (!existsProductV2){
            throw new NotFoundException("product with id " + productV2Id + " does not exist");
        }
        productV2Repository.deleteById(productV2Id);

    }
}
