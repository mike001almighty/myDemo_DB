package com.example.demo.service;

import com.example.demo.exception.AlreadyExistsException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Consumer;
import com.example.demo.rep.ConsumerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConsumerServiceTest {

    @Mock
    private ConsumerRepository consumerRepository;
    @InjectMocks
    Consumer consumer;
    @InjectMocks
    private ConsumerService underTest;

    private Consumer testConsumer;

    @BeforeEach
    void setUp() {
        underTest = new ConsumerService(consumerRepository);
        this.testConsumer = new Consumer(2L,"test","test@gmail.com",32);
    }

    @Test
    void testGetConsumers() {
        // when
        underTest.getConsumers();
        // then
        verify(consumerRepository).findAll();
    }

    @Test
    void testGetConsumerById() throws NotFoundException {
        //given
        long id = 1;
//        underTest.addNewConsumer(new Consumer(1L,"Terry","terry@gmail.com",25));
//        System.out.println(underTest.getConsumers());
//        Consumer consumer = new Consumer(1L,"Terry","terry@gmail.com",25);
//        when(underTest.getConsumerById(1L)).thenReturn(new Consumer(1L,"Terry","terry@gmail.com",25));
//
//        Consumer expected = underTest.getConsumerById(1L);
//
//        assertEquals(new Consumer(1L,"Terry","terry@gmail.com",25), underTest.getConsumerById(1L));

//        // given
//        final Long id = 100L;
//        final Consumer consumer = new Consumer(
//                id,
//                "Terry",
//                "terry@gmail.com",
//                25
//        );
        given(consumerRepository.findConsumerById(id)).willReturn(Optional.of(consumer));

//        underTest.addNewConsumer(consumer);
//        given(consumerRepository.findById(id)).willReturn(Optional.of(consumer));
//        final Consumer expected = underTest.getConsumerById(id);
//        assertThat(expected).isNotNull();
//        consumerRepository.save(consumer);
//        underTest.addNewConsumer(consumer);
//        Consumer expected = underTest.getConsumerById(7L);
//        assertThat(expected).isInstanceOf(Consumer.class);
        underTest.getConsumerById(id);
//        verify(consumerRepository).findConsumerById(1L).get();
        verify(consumerRepository).getById(id);
    }

    @Test
    void testAddNewConsumer() throws AlreadyExistsException {
        // given
        Consumer consumer = new Consumer(
                "Terry",
                "terry@gmail.com",
                25
        );
        // when
        underTest.addNewConsumer(consumer);
        // then
        ArgumentCaptor<Consumer> consumerArgumentCaptor = ArgumentCaptor.forClass(Consumer.class);
        verify(consumerRepository)
                .save(consumerArgumentCaptor.capture());
        Consumer capturedConsumer = consumerArgumentCaptor.getValue();
        assertThat(capturedConsumer).isEqualTo(consumer);
    }


    @Test
    void deleteConsumer() throws NotFoundException {
        long id = 2L;
        Consumer consumer = new Consumer (2L,"tom","tom", 25);
        given(consumerRepository.existsById(id)).willReturn(Boolean.TRUE);
        when(consumerRepository.findConsumerById(id)).thenReturn(Optional.of(consumer));

        willDoNothing().given(consumerRepository).deleteById(id);
        underTest.deleteConsumer(id);
        verify(consumerRepository).deleteById(id);


        // given
//        Consumer consumer = new Consumer ("tom","tom", 25);
//        consumer.setId(2L);
//        long id = 2L;
//
//        underTest.addNewConsumer(consumer);
//
//        when(consumerRepository.deleteById(any())).getMock();
//
//        given(consumerRepository.existsById(id))
//                .willReturn(true);
//        given(consumerRepository.deleteById(id)).willReturn(Optional.empty());
//        given(underTest.deleteConsumer(id):notNull());
        // when
//        underTest.deleteConsumer(id);

        // then
//        verify(consumerRepository).deleteById(id);

//        try {
//            underTest.deleteConsumer(id);
//        } catch (Exception e) {
//            System.out.println(e);
//        }

//        verify(consumerRepository, times(1)).deleteById(any());
//        verify(consumerRepository).deleteById(id);
    }

}