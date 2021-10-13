package com.example.demo.service;


import com.example.demo.exception.CustomRestServiceException;
import com.example.demo.model.Consumer;
import com.example.demo.model.CreateOrder;
import com.example.demo.model.Product;
import com.example.demo.model.PurchaseOrder;
import com.example.demo.rep.ConsumerRepository;
import com.example.demo.rep.ProductRepository;
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

    @Autowired
    public PurchaseOrderService(PurchaseOrderRepository purchaseOrderRepository, ConsumerRepository consumerRepository, ProductRepository productRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.consumerRepository = consumerRepository;
        this.productRepository = productRepository;
    }

    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrderRepository.findAll();
    }

    public void addNewPurchaseOrder(CreateOrder createOrder /*String description, Long consumer_id, Long product_id */) throws CustomRestServiceException {

        PurchaseOrder po = new PurchaseOrder();

        po.setDescription(createOrder.getDescription());

        po.setConsumer(consumerRepository.findConsumerById(createOrder.getConsumerId()).get());

        boolean existsp = productRepository.existsById(createOrder.getProductId());
        if (!existsp) {
            throw new IllegalStateException("product with id " + createOrder.getProductId() + " does not exist");
        }
//        Optional<Product> productOptional = productRepository.findProductById(createOrder.getProductId());
//        if (productOptional.isEmpty()) {
//            throw new IllegalStateException("Product with id" +  createOrder.getProductId() + " does not exist");
//        }
        po.setProduct(productRepository.findProductById(createOrder.getProductId()).get());


        purchaseOrderRepository.save(po);
        System.out.println(po);
    }

}
