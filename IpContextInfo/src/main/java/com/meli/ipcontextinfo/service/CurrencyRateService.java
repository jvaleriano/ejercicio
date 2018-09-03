package com.meli.ipcontextinfo.service;

import com.meli.ipcontextinfo.model.RateResponseCurrencyCode;
import java.math.BigDecimal;

/**
 *
 * @author jvaleriano
 */
public interface CurrencyRateService {
    
    /**
     *
     * @param currency code https://es.wikipedia.org/wiki/ISO_4217
     * @param responseCurrencyCode 
     * @see RateResponseCurrencyCode
     * @return rate of the currency in responseCurrencyCode currency value
     */
    BigDecimal getCurrencyRate(String currency , RateResponseCurrencyCode responseCurrencyCode);
     
    /**
     *
     * @param currency code https://es.wikipedia.org/wiki/ISO_4217
     * @see RateResponseCurrencyCode
     * @return rate of the currency in American Dollar U$S
     */
    BigDecimal getCurrencyDolarRate(String currency);
    
}