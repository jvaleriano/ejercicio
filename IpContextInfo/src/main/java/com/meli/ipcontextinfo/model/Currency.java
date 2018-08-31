package com.meli.ipcontextinfo.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author VAL13448
 */
public class Currency {
    
    private String code;
    private String symbol;
    private BigDecimal rate = BigDecimal.ZERO;

    public Currency(String code, String symbol, BigDecimal rate) {
        this.code = code;
        this.symbol = symbol;
        this.rate = rate;
    }

    public Currency(String code, String symbol) {
        this.code = code;
        this.symbol = symbol;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.code);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Currency other = (Currency) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.symbol, other.symbol)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Currency{" + "code=" + code + ", symbol=" + symbol + ", rate=" + rate + '}';
    }    
    
}