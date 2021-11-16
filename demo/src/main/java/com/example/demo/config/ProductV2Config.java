//package com.example.demo.config;
//
//import com.example.demo.model.Product;
//import com.example.demo.model.ProductV2;
//import com.example.demo.rep.ProductRepository;
//import com.example.demo.rep.ProductV2Repository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class ProductV2Config {
//
//    @Bean
//    CommandLineRunner commandLineRunnerProductV2(ProductV2Repository repository){
//        return args -> {
//            ProductV2 item_1 = new ProductV2(
//                    "item_1",
//                    "electronics",
//                    25
//            );
//
//            ProductV2 item_2 = new ProductV2(
//                    "item_2",
//                    "electronics",
//                    26
//            );
//
//            repository.saveAll(
//                    List.of(item_1, item_2)
//            );
//        };
//    }
//}
//
