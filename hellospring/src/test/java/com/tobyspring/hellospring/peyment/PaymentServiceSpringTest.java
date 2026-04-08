package com.tobyspring.hellospring.peyment;

import com.tobyspring.hellospring.ObjectFactory;
import com.tobyspring.hellospring.TestObjectFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.Assertions.assertThat;


class PaymentServiceSpringTest {

    @Test
    @DisplayName("prepare 메소드가 요구사항 3가를 잘 충족했는지 검증")
    void convertedAmount() throws IOException {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(TestObjectFactory.class);
        PaymentService paymentService = beanFactory.getBean(PaymentService.class);

        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);

        assertThat(payment.getExRate()).isEqualByComparingTo(valueOf(1_000));
        assertThat(payment.getConvertedAmount()).isEqualByComparingTo(valueOf(10_000));

        // 원화환산금액의 유효시간 계산
//        assertThat(payment.getVaildUntil()).isAfter(LocalDateTime.now());
//        assertThat(payment.getVaildUntil()).isBefore(LocalDateTime.now().plusMinutes(30));
    }
}