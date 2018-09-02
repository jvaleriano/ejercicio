package com.meli.ipcontextinfo.model;

import java.util.Objects;

/**
 *
 * @author VAL13448
 */
public class CountryName {

    private String value;
    private String espValue;

    /**
     *
     * @param value
     * @param espValue
     */
    public CountryName(String value, String espValue) {
        this.value = value;
        this.espValue = espValue;
    }

    /**
     *
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     *
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     *
     * @return
     */
    public String getEspValue() {
        return espValue;
    }

    /**
     *
     * @param espValue
     */
    public void setEspValue(String espValue) {
        this.espValue = espValue;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.value);
        hash = 79 * hash + Objects.hashCode(this.espValue);
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
        final CountryName other = (CountryName) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        if (!Objects.equals(this.espValue, other.espValue)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CountryName{" + "name=" + value + ", nameEsp=" + espValue + '}';
    }

}
