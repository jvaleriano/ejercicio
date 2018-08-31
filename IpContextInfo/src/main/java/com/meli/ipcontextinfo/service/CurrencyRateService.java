package com.meli.ipcontextinfo.service;

import com.meli.ipcontextinfo.model.RateResponseCurrencyCode;
import java.math.BigDecimal;

/**
 *
 * @author VAL13448
 */
public interface CurrencyRateService {
    
      BigDecimal getCurrencyRate(String currency , RateResponseCurrencyCode responseCurrencyCode);
     
      BigDecimal getCurrencyDolarRate(String currency);
    
}