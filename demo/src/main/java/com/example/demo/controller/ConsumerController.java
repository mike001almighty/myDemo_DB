package com.example.demo.controller;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Consumer;
import com.example.demo.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class ConsumerController {

    private final ConsumerService consumerService;

    @Autowired
    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @GetMapping
    public List<Consumer> getConsumers(){
        return consumerService.getConsumers();
    }

    @GetMapping(path = "{consumerId}")
    public Consumer getConsumer(long consumerId) throws NotFoundException {
        return consumerService.getConsumerById(consumerId);
    }

    @PostMapping
    public void registerNewConsumer (@RequestBody Consumer consumer) {
        consumerService.addNewConsumer(consumer);
    }

    @DeleteMapping(path = "{consumerId}")
    public void deleteConsumer(@PathVariable("consumerId") Long consumerId) throws NotFoundException {
        consumerService.deleteConsumer(consumerId);
    }

    @PutMapping(path = "{consumerId}")
    public Consumer updateConsumer( @RequestBody Consumer consumer) throws NotFoundException {
        return consumerService.updateConsumer(consumer);
     }

}
