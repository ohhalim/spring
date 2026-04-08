package com.tobyspring.hellospring;

import com.tobyspring.hellospring.exrate.WebApiExRateProvider;
import com.tobyspring.hellospring.peyment.ExRateProvider;
import com.tobyspring.hellospring.peyment.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectFactory {
    @Bean
    public PaymentService paymentService() {
        return new PaymentService(exRateProvider());
    }

    @Bean   
    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider();
    }
}
                                                                                