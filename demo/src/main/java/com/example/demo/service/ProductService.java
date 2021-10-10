package com.example.demo.service;


import com.example.demo.model.Product;
import com.example.demo.rep.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.getById(id);
    }



    public void addNewProduct(Product product) {
//        Optional<Product> consumerOptional = productRepository.findProductByDesc(product.getDescription());
//        if (consumerOptional.isPresent()) {
//            throw new IllegalStateException("description taken");
//        }
        productRepository.save(product);
        System.out.println(product);
    }

    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if (!exists){
            throw new IllegalStateException("product with id " + productId + " does not exist");
        }
        productRepository.deleteById(productId);

    }





}
