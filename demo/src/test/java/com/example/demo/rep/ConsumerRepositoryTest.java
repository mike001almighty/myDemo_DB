package com.example.demo.rep;

import com.example.demo.model.Consumer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class ConsumerRepositoryTest {

    @Autowired
    private ConsumerRepository underTest;

//    @AfterEach
//    void tearDown() {
//        underTest.deleteAll();
//    }

    @Test
    void testFindConsumerByEmail() {
        // given
        String email = "jamila@gmail.com";
        Consumer consumer = new Consumer(
                "Jamila",
                "jamila@gmail.com",
                22

        );
        underTest.save(consumer);

        // when
        Consumer expected = underTest.findConsumerByEmail(email).get();

        // then
        assertThat(expected).isEqualTo(consumer);
    }

    @Test
    void testFindConsumerById() {
        // given
        Consumer consumer = new Consumer(
                "Bob",
                "bob@gmail.com",
                22

        );
        underTest.save(consumer);

        // when
        Consumer expected = underTest.findConsumerById(1L).get();

        // then
//        assertTrue(expected.isPresent() && consumer.equals(expected.get()));
//        assertThat("expected", opt.get()).isEqualTo(consumer);
        assertThat(expected.equals(consumer));
    }
}