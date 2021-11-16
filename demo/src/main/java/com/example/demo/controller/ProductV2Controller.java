package com.example.demo.controller;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Product;
import com.example.demo.model.ProductV2;
import com.example.demo.service.ProductService;
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

//    private final ProductV2Service productV2Service;
    private final ProductService productService;

    @Autowired
    public ProductV2Controller(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts (){
        return productService.getProducts();
    }

    @GetMapping(path = "{productId}")
    public Product getProduct (@PathVariable("productId") Long productId) throws NotFoundException {
        return productService.getProductById(productId);
    }

    @PostMapping
    public void registerNewProduct (@Valid @RequestBody Product product)  {
        productService.addNewProduct(product);
    }

    @DeleteMapping(path = "{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId) throws NotFoundException {
        productService.deleteProduct(productId);
    }
}
