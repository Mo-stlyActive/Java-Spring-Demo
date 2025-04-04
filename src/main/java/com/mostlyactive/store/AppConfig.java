package com.mostlyactive.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Value("${service.payment:stripe}")
    private String paymentChoice;


    @Bean
    public PaymentService stripe(){
        return new StripePaymentService();
    }

    @Bean
    public PaymentService payPal(){
        return new PayPalPaymentService();
    }

    @Bean
    public OrderService orderService(){
        if(paymentChoice.equals("stripe")) {
            return new OrderService(stripe());
        }
        return new OrderService(payPal());
    }
}
