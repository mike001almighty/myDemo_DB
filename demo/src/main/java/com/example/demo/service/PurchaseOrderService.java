package com.example.demo.service;


import com.example.demo.exception.CustomRestServiceException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Consumer;
import com.example.demo.model.CreateOrder;
import com.example.demo.model.Product;
import com.example.demo.model.PurchaseOrder;
import com.example.demo.rep.ConsumerRepository;
import com.example.demo.rep.ProductRepository;
import com.example.demo.rep.ProductV2Repository;
import com.example.demo.rep.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final ConsumerRepository consumerRepository;
    private final ProductRepository productRepository;
    private final ProductV2Repository productV2Repository;

    @Autowired
    public PurchaseOrderService(PurchaseOrderRepository purchaseOrderRepository, ConsumerRepository consumerRepository, ProductRepository productRepository, ProductV2Repository productV2Repository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.consumerRepository = consumerRepository;
        this.productRepository = productRepository;
        this.productV2Repository = productV2Repository;
    }

    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrderRepository.findAll();
    }

    public List<PurchaseOrder> getPurchaseOrdersV2() {
        return purchaseOrderRepository.findAll();
    }

    public void addNewPurchaseOrder(CreateOrder createOrder) throws /*CustomRestServiceException,*/ NotFoundException {

        PurchaseOrder purchaseOrder = new PurchaseOrder();

        purchaseOrder.setDescription(createOrder.getDescription());

        purchaseOrder.setConsumer(consumerRepository.findConsumerById(createOrder.getConsumerId()).get());

        boolean existsProduct = productRepository.existsById(createOrder.getProductId());
        if (!existsProduct) {
            throw new NotFoundException("product with id " + createOrder.getProductId() + " does not exist");
        }
        purchaseOrder.setProduct(productRepository.findProductById(createOrder.getProductId()).get());

//        purchaseOrder.setProductV2(productV2Repository.findProductV2ById(1L).get());

        purchaseOrder.setProductV2(null);

        purchaseOrderRepository.save(purchaseOrder);
        System.out.println(purchaseOrder);
    }

    public void addNewPurchaseOrderV2(CreateOrder createOrder) throws /*CustomRestServiceException,*/ NotFoundException {

        PurchaseOrder purchaseOrder = new PurchaseOrder();

        purchaseOrder.setDescription(createOrder.getDescription());

        purchaseOrder.setConsumer(consumerRepository.findConsumerById(createOrder.getConsumerId()).get());

        boolean existsProductV2 = productV2Repository.existsById(createOrder.getProductId());
        if (!existsProductV2) {
            throw new NotFoundException("product with id " + createOrder.getProductId() + " does not exist");
        }
//        purchaseOrder.setProduct(productRepository.findProductById(createOrder.getProductId()).get());
        purchaseOrder.setProductV2(productV2Repository.findProductV2ById(createOrder.getProductId()).get());

        purchaseOrder.setProduct(null);

        purchaseOrderRepository.save(purchaseOrder);
        System.out.println(purchaseOrder);
    }

}
