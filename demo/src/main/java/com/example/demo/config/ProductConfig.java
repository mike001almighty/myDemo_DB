package com.example.demo.config;


import com.example.demo.model.Consumer;
import com.example.demo.model.Product;
import com.example.demo.rep.ConsumerRepository;
import com.example.demo.rep.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunnerProduct(ProductRepository repository){
        return args -> {
            Product item_1 = new Product(
//                    1L,
                    "item_1",
                    25

            );

            Product item_2 = new Product(
//                    2L,
                    "item_2",
                    26

            );

            repository.saveAll(
                    List.of(item_1, item_2)
            );
        };
    }

}
