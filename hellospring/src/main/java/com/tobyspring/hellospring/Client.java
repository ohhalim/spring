package com.tobyspring.hellospring;

import java.io.IOException;
import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) throws IOException {
        ObjectFactory objectFastroy = new ObjectFactory();
        PaymentService paymentService = objectFastroy.paymentService();

        Payment payment = paymentService.prepare(100L,"USD", BigDecimal.valueOf(50.7));
        System.out.println(payment);
    }
}
                                                                            