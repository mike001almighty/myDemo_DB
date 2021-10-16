package com.example.demo.rep;


import com.example.demo.model.ProductV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductV2Repository extends JpaRepository<ProductV2, Long> {

    @Query("SELECT p FROM ProductV2 p WHERE p.description = ?1")
    Optional<ProductV2> findProductV2ByDesc(String description);

    @Query("SELECT p FROM ProductV2 p WHERE p.category = ?1")
    Optional<ProductV2> findProductV2ByCat(String category);

    @Query("SELECT p FROM ProductV2 p WHERE p.id = ?1")
    Optional<ProductV2> findProductV2ById(Long id);

}