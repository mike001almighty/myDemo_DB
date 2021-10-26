package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Consumer;
import com.example.demo.rep.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumerService {

    private ConsumerRepository consumerRepository;

    @Autowired
    public ConsumerService(ConsumerRepository consumerRepository) {
        this.consumerRepository = consumerRepository;
    }

    public List<Consumer> getConsumers() {
        return consumerRepository.findAll();
    }

    public Consumer getConsumerById(Long id) throws NotFoundException {
        consumerRepository.findConsumerById(id).orElseThrow(() -> new NotFoundException("consumer with id" +id + " does not exist"));
        return consumerRepository.getById(id);
    }

    public void addNewConsumer(Consumer consumer) {
        Optional<Consumer> consumerOptional = consumerRepository.findConsumerByEmail(consumer.getEmail());
        if (consumerOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        consumerRepository.save(consumer);
        System.out.println(consumer);
    }

    public void deleteConsumer(Long consumerId) throws NotFoundException {
        boolean existsConsumer = consumerRepository.existsById(consumerId);
        if (!existsConsumer){
            throw new IllegalStateException("consumer with id " + consumerId + " does not exist");
        }
        consumerRepository.findConsumerById(consumerId).orElseThrow(() -> new NotFoundException("consumer with id" + consumerId + " does not exist"));
        consumerRepository.deleteById(consumerId);
    }

    public Consumer updateConsumer(Consumer consumer) throws NotFoundException{
        consumerRepository.findConsumerById(consumer.getId()).orElseThrow(() -> new NotFoundException("consumer with id" + consumer.getId() + " does not exist"));
        Consumer con = consumerRepository.getById(consumer.getId());
        con.setName(consumer.getName());
        con.setEmail(consumer.getEmail());
        return consumerRepository.save(con);
    }

}
