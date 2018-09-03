package com.meli.ipcontextinfo.service.model;

import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author jvaleriano
 */
public class CurrencyRateDto {

    private boolean success;
    private float timestamp;
    private String base;
    private String date;
    private Map<String,BigDecimal> rates;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public float getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(float timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<String, BigDecimal> getRates() {
        return rates;
    }

    public void setRates(Map<String, BigDecimal> rates) {
        this.rates = rates;
    }
}