package com.example.demo.controller;


import com.example.demo.exception.CustomRestServiceException;
import com.example.demo.model.Consumer;
import com.example.demo.model.CreateOrder;
import com.example.demo.model.Product;
import com.example.demo.model.PurchaseOrder;
import com.example.demo.service.ConsumerService;
import com.example.demo.service.ProductService;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/orders")
public class PurchaseOrderController {

    private PurchaseOrderService purchaseOrderService;

    @Autowired
    public PurchaseOrderController(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    @Autowired
    ConsumerService consumerService;

    @Autowired
    ProductService productService;

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Consumer")  // 404
    public class OrderNotFoundException extends RuntimeException {
        // ...
    }

    @GetMapping
    public List<PurchaseOrder> getPurchaseOrders(){
        return purchaseOrderService.getPurchaseOrders();
    }

    @PostMapping
    public void registerNewPurchaseOrder (@RequestBody CreateOrder createOrder
           /* String description, Long consumer_id, Long product_id*/) throws CustomRestServiceException {

/*
          PurchaseOrder po = new PurchaseOrder();
//        purchaseOrder.setId(1L);
//        purchaseOrder.setDescription(description);
          po.setDescription(createOrder.getDescription());
          Optional<Consumer> consumerOptional = Optional.ofNullable(consumerService.getConsumerById(createOrder.getConsumerId()));
          if (consumerOptional.isEmpty()) {
              throw new IllegalStateException("User does not exist");
        }
    */
        Consumer consumer = consumerService.getConsumerById(createOrder.getConsumerId());
        if (consumer == null) throw new OrderNotFoundException();
//        boolean exists = consumerService.existsById(consumerId);
//        if (!exists){
//            throw new IllegalStateException("consumer with id " + consumerId + " does not exist");
//        }
 /*         po.setConsumer(consumerService.getConsumerById(createOrder.getConsumerId()));

        Optional<Product> productOptional = Optional.ofNullable(productService.getProductById(createOrder.getProductId()));
        if (productOptional.isEmpty()) {
            throw new IllegalStateException("Product does not exist");
        }
          po.setProduct(productService.getProductById(createOrder.getProductId()));
*/
          purchaseOrderService.addNewPurchaseOrder(createOrder) ;
//        purchaseOrderService.addNewPurchaseOrder(description, consumer_id, product_id);
    }


}




