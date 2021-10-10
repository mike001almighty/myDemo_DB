package com.example.demo.config;

import com.example.demo.model.Consumer;
import com.example.demo.rep.ConsumerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.CommandLinePropertySource;

import java.util.List;

@Configuration
public class ConsumerConfig {

    @Bean
    CommandLineRunner commandLineRunner(ConsumerRepository   repository){
        return args -> {
            Consumer bob = new Consumer(
                    "Bob",
                    "bob@gmail.com",
                    25

            );

            Consumer pete = new Consumer(
                    "Pete",
                    "pete@gmail.com",
                    26

            );

            repository.saveAll(
                    List.of(bob, pete)
            );
        };
    }


}
