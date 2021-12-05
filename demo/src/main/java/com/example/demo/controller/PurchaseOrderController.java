package com.example.demo.controller;

import com.example.demo.exception.CustomRestServiceException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Consumer;
import com.example.demo.model.CreateOrder;
import com.example.demo.model.Product;
import com.example.demo.model.PurchaseOrder;
import com.example.demo.service.ConsumerService;
//import com.example.demo.service.ProductService;
import com.example.demo.service.ProductV2Service;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class PurchaseOrderController {

    private PurchaseOrderService purchaseOrderService;

    @Autowired
    public PurchaseOrderController(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    @Autowired
    ConsumerService consumerService;

    @Autowired
    ProductV2Service productService;

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Consumer")  // 404
    public class OrderNotFoundException extends RuntimeException {
        // ...
    }

    @GetMapping(path = {"api/v1/orders",
                        "api/v2/orders"})
//    @GetMapping(path = "api/v1/orders")
    public List<PurchaseOrder> getPurchaseOrders(){
        return purchaseOrderService.getPurchaseOrders()/*.stream().filter((p) -> p.getProductV2()==null).collect(Collectors.toList())*/;

    }

//    @GetMapping(path = "api/v2/orders")
//    public List<PurchaseOrder> getPurchaseOrdersV2(){
//        return purchaseOrderService.getPurchaseOrders().stream().filter((p) -> p.getProduct()==null).collect(Collectors.toList());
//}

    @PostMapping(path = {"api/v1/orders",
                        "api/v2/orders"})
    public void registerNewPurchaseOrder (@RequestBody CreateOrder createOrder) throws CustomRestServiceException, NotFoundException {
//        PurchaseOrder po = new PurchaseOrder();
//        po.setDescription(createOrder.getDescription());
//          Optional<Consumer> consumerOptional = Optional.ofNullable(consumerService.getConsumerById(createOrder.getConsumerId()));
//          if (consumerOptional.isEmpty()) {
//              throw new IllegalStateException("User does not exist");
//        }
//        Consumer consumer = consumerService.getConsumerById(createOrder.getConsumerId());
//        if (consumer == null) throw new NotFoundException("Consumer with id" + createOrder.getConsumerId() + "does not exist");
//        boolean exists = consumerService.existsById(consumerId);
//        if (!exists){
//            throw new IllegalStateException("consumer with id " + consumerId + " does not exist");
//        }
//        po.setConsumer(consumerService.getConsumerById(createOrder.getConsumerId()));
//
//        Optional<Product> productOptional = Optional.ofNullable(productService.getProductById(createOrder.getProductId()));
//        if (productOptional.isEmpty()) {
//            throw new IllegalStateException("Product does not exist");
//        }
//          po.setProduct(productService.getProductById(createOrder.getProductId()));

        purchaseOrderService.addNewPurchaseOrder(createOrder) ;
    }

//    @PostMapping(path = "api/v2/orders")
//    public void registerNewPurchaseOrderV2 (@RequestBody CreateOrder createOrder) throws CustomRestServiceException, NotFoundException {
//        purchaseOrderService.addNewPurchaseOrderV2(createOrder);
//    }
}




