package com.tobyspring.hellospring.peyment;

import com.tobyspring.hellospring.exrate.WebApiExRateProvider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.math.BigDecimal.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    @Test
    @DisplayName("prepare 메소드가 요구사항 3가를 잘 충족했는지 검증")
    void prepare() throws IOException {
        PaymentService paymentService = new PaymentService(new ExRateProviderStub(valueOf(500)));
        Payment payment = paymentService.prepare(1L, "USD", BigDecimal.TEN);
        // 환율정보 가져온다
        assertThat(payment.getExRate()).isEqualTo(valueOf(500));

        // 원화환산금 계산
        assertThat(payment.getConvertedAmount())
                .isEqualTo(valueOf(5_000));
        
        // 원화환산금액의 유효시간 계산
        assertThat(payment.getVaildUntil()).isAfter(LocalDateTime.now());
        assertThat(payment.getVaildUntil()).isBefore(LocalDateTime.now().plusMinutes(30));
                
    }
}