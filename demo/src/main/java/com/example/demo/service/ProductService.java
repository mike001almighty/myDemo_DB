package com.example.demo.service;


import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Product;
import com.example.demo.rep.ProductRepository;
import org.hibernate.ObjectNotFoundException;
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

    public Product getProductById(Long id) throws NotFoundException{
        boolean existsProduct = productRepository.existsById(id);
        if (!existsProduct) {
            throw new NotFoundException("product with id " + id + " does not exist");
        }
            return productRepository.getById(id);
    }

    public void addNewProduct(Product product) {
        productRepository.save(product);
        System.out.println(product);
    }

    public void deleteProduct(Long productId) throws NotFoundException {
        boolean existsProduct = productRepository.existsById(productId);
        if (!existsProduct){
            throw new NotFoundException("product with id " + productId + " does not exist");
        }
        productRepository.deleteById(productId);

    }
}
