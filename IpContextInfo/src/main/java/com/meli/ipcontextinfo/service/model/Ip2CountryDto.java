package com.meli.ipcontextinfo.service.model;

import java.util.Objects;

/**
 *
 * @author jvaleriano
 */
public class Ip2CountryDto {
    
    private String countryCode;
    private String countryCode3;
    private String countryName;
    private String countryEmoji;

    public Ip2CountryDto() {
    }

    public Ip2CountryDto(String countryCode, String countryCode3, String countryName, String countryEmoji) {
        this.countryCode = countryCode;
        this.countryCode3 = countryCode3;
        this.countryName = countryName;
        this.countryEmoji = countryEmoji;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode3() {
        return countryCode3;
    }

    public void setCountryCode3(String countryCode3) {
        this.countryCode3 = countryCode3;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryEmoji() {
        return countryEmoji;
    }

    public void setCountryEmoji(String countryEmoji) {
        this.countryEmoji = countryEmoji;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.countryCode3);
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
        final Ip2CountryDto other = (Ip2CountryDto) obj;
        if (!Objects.equals(this.countryCode3, other.countryCode3)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ip2Country{" + "countryCode=" + countryCode + ", countryCode3=" + countryCode3 + ", countryName=" + countryName + ", countryEmoji=" + countryEmoji + '}';
    }    
}
