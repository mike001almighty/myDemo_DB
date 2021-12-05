package com.example.demo.controller;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Product;
import com.example.demo.model.ProductV2;
//import com.example.demo.service.ProductService;
import com.example.demo.service.ProductV2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/products")
@Validated
public class ProductController {

//    private final ProductService productService;
    private final ProductV2Service productV2Service;

    @Autowired
    public ProductController(ProductV2Service productV2Service) {
        this.productV2Service = productV2Service;
    }

    @GetMapping
    public List<ProductV2> getProducts(){
        return productV2Service.getProductsV2();
    }

    @GetMapping(path = "{productId}")
    public ProductV2 getProduct(@PathVariable("productId") Long productId) throws NotFoundException {
        return productV2Service.getProductV2ById(productId);
    }

    @PostMapping
    public void registerNewProduct (@Valid @RequestBody Product product)  {
        ProductV2 productv2 = new ProductV2();
        productv2.setId(product.getId());
        productv2.setDescription(product.getDescription());
        productv2.setPrice(product.getPrice());
        productv2.setCategory(null);
        productV2Service.addNewProductV2(productv2);
    }

    @DeleteMapping(path = "{productId}")
    public void deleteConsumer(@PathVariable("productId") Long productId) throws NotFoundException {
        productV2Service.deleteProductV2(productId);
    }

}
