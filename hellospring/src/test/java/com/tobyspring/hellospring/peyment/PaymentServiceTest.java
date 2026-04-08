package com.tobyspring.hellospring.peyment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.lang.NonNull;

import java.io.IOException;
import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

class PaymentServiceTest {

    @Test
    @DisplayName("prepare 메소드가 요구사항 3가를 잘 충족했는지 검증")
    void convertedAmount() throws IOException {
        
        testAmount(valueOf(500), valueOf(5_000));
        testAmount(valueOf(1_000), valueOf(10_000));
        testAmount(valueOf(1_000), valueOf(10_000));

        // 원화환산금액의 유효시간 계산
//        assertThat(payment.getVaildUntil()).isAfter(LocalDateTime.now());
//        assertThat(payment.getVaildUntil()).isBefore(LocalDateTime.now().plusMinutes(30));
    }

    private static void testAmount(BigDecimal exRate, BigDecimal convertedAmount) throws IOException {
        PaymentService paymentService = new PaymentService(new ExRateProviderStub(exRate));
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);
        assertThat(payment.getExRate()).isEqualByComparingTo(valueOf(500));
        assertThat(payment.getConvertedAmount()).isEqualByComparingTo(convertedAmount);
    }
}