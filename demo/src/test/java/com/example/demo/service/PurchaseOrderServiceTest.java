package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Consumer;
import com.example.demo.model.CreateOrder;
import com.example.demo.model.PurchaseOrder;
import com.example.demo.rep.ConsumerRepository;
import com.example.demo.rep.ProductV2Repository;
import com.example.demo.rep.PurchaseOrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;

@ExtendWith(MockitoExtension.class)
class PurchaseOrderServiceTest {

    @Mock
    private PurchaseOrderRepository purchaseOrderRepository;
    @Mock
    private ConsumerRepository consumerRepository;
    @Mock
    private ProductV2Repository productV2Repository;
    @InjectMocks
    PurchaseOrder purchaseOrder;
    @InjectMocks
    private PurchaseOrderService underTest;
    private Consumer consumer;

    @BeforeEach
    void setUp() {
        underTest = new PurchaseOrderService(purchaseOrderRepository, consumerRepository, productV2Repository);
        consumer = new Consumer("bob", "bob@gmail.com", 25);
    }

    @Test
    void addNewPurchaseOrderThrow() {
        CreateOrder createOrder = new CreateOrder();
        createOrder.setDescription("example");
        createOrder.setConsumerId(1L);
        createOrder.setProductId(1L);

        long id = 1L;
        // given
//        given(purchaseOrderRepository.existsById(id))
//                .willReturn(false);
        // when
        // then
        assertThatThrownBy(() -> underTest.addNewPurchaseOrder(createOrder))
                .isInstanceOf(NotFoundException.class)
                .hasMessageContaining("consumer with id " + createOrder.getConsumerId() + " does not exist");


    }

    @Test
    void addNewPurchaseOrderThrow2() {
        CreateOrder createOrder = new CreateOrder();
        createOrder.setDescription("example");
        createOrder.setConsumerId(1L);
        createOrder.setProductId(1L);

        long id = 1L;
        // given
        given(consumerRepository.existsById(id))
                .willReturn(true);
//        willDoNothing().given(purchaseOrder).setConsumer(any());
        given(consumerRepository.findConsumerById(any())).willReturn(Optional.of(consumer));
        // when
        // then
        assertThatThrownBy(() -> underTest.addNewPurchaseOrder(createOrder))
                .isInstanceOf(NotFoundException.class)
                .hasMessageContaining("product with id " + createOrder.getProductId() + " does not exist");


    }



}