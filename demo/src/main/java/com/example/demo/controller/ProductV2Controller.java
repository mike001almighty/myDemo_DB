package com.example.demo.controller;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Product;
import com.example.demo.model.ProductV2;
import com.example.demo.service.ProductV2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v2/products")
@Validated
public class ProductV2Controller {

    private final ProductV2Service productV2Service;

    @Autowired
    public ProductV2Controller(ProductV2Service productV2Service) {
        this.productV2Service = productV2Service;
    }

    @GetMapping
    public List<ProductV2> getProductsV2 (){
        return productV2Service.getProductsV2();
    }

    @GetMapping(path = "{productId}")
    public ProductV2 getProductV2 (@PathVariable("productId") Long productId) throws NotFoundException {
        return productV2Service.getProductV2ById(productId);
    }

    @PostMapping
    public void registerNewProductV2 (@Valid @RequestBody ProductV2 product)  {
        productV2Service.addNewProductV2(product);
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProductV2(@PathVariable("productId") Long productId) throws NotFoundException {
        productV2Service.deleteProductV2(productId);
    }
}