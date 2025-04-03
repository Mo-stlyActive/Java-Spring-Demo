package com.mostlyactive.store;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Service
public class OrderService {

    private PaymentService paymentService;

    public OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
        System.out.println("OrderService created");
    }

    //postconstruct annotation runs after the constructure. instance made now do this.
    @PostConstruct
    public void init(){
        System.out.println("orderService PostConstruct");
    }

    @PreDestroy
    public void cleanup(){
        System.out.println("orderService destroyed");
    }

    public void placeOrder(){
        paymentService.processPayment(10);
    }
}
