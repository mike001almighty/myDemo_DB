package com.example.demo.controller;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Consumer;
import com.example.demo.model.Product;
import com.example.demo.service.ConsumerService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/products")
@Validated
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping(path = "{productId}")
    public Product getProduct(@PathVariable("productId") Long productId) throws NotFoundException {
        return productService.getProductById(productId);
    }

    @PostMapping
    public void registerNewProduct (@Valid @RequestBody Product product)  {
        productService.addNewProduct(product);
    }

    @DeleteMapping(path = "{productId}")
    public void deleteConsumer(@PathVariable("productId") Long productId) throws NotFoundException {
        productService.deleteProduct(productId);
    }

}
