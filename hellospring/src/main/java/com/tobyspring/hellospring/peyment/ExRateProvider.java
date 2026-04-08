package com.tobyspring.hellospring.peyment;

import java.io.IOException;
import java.math.BigDecimal;

public interface ExRateProvider {
    BigDecimal getExRate(String currency) throws IOException;
}
