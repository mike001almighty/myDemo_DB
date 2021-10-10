package com.example.demo.service;

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

    public Consumer getConsumerById(Long id) {
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

    public void deleteConsumer(Long consumerId) {
        boolean exists = consumerRepository.existsById(consumerId);
        if (!exists){
            throw new IllegalStateException("consumer with id " + consumerId + " does not exist");
        }
        consumerRepository.deleteById(consumerId);

    }

//    @Transactional
//    public void updateConsumer(Long consumerId, String name, String email) {
//        Consumer consumer = consumerRepository.findById(consumerId)
//                .orElseThrow(() -> new IllegalStateException("consumer with id" + consumerId + "does not exist"));
//        System.out.println(consumer);
//        System.out.println(name);
//
//        if (name != null && name.length()>0 && !Objects.equals(consumer.getName(), name)) {
//            consumer.setName(name);
//            System.out.println(name);
//        }
//
//        if (email != null && email.length()>0 && !Objects.equals(consumer.getEmail(), email)) {
//            Optional<Consumer> consumerOptional = consumerRepository.findConsumerByEmail(email);
//            if (consumerOptional.isPresent()) {
//                throw new IllegalStateException("email taken");
//            }
//            consumer.setEmail(email);
//        }
//
//    }

//    public Consumer updateConsumer(Long consumerId, String name, String email) {
      public Consumer updateConsumer(Consumer consumer) {
        Consumer con = consumerRepository.getById(consumer.getId());
        con.setName(consumer.getName());
        con.setEmail(consumer.getEmail());
        return consumerRepository.save(con);



    }


}
