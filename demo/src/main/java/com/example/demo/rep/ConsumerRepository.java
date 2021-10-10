package com.example.demo.rep;

import com.example.demo.model.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {

    @Query("SELECT s FROM Consumer s WHERE s.email = ?1")
    Optional<Consumer> findConsumerByEmail(String email);

    @Query("SELECT s FROM Consumer s WHERE s.id = ?1")
    Optional<Consumer> findConsumerById(Long id);

}
