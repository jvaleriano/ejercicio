package com.meli.ipcontextinfo.model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author VAL13448
 */
public class Country {

    private CountryName name;
    private String isoCode;
    private List<Languaje> language;
    private Currency currency;
    private List<TimeZone> timezone;
    private Coordinate coordinates;

    public Country() {
    }

    public Country(CountryName name, String isoCode, List<Languaje> language, Currency currency, List<TimeZone> timezone, Coordinate coordinates) {
        this.name = name;
        this.isoCode = isoCode;
        this.language = language;
        this.currency = currency;
        this.timezone = timezone;
        this.coordinates = coordinates;
    }
   
    public CountryName getName() {
        return name;
    }

    public void setName(CountryName name) {
        this.name = name;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public List<Languaje> getLanguage() {
        return language;
    }

    public void setLanguage(List<Languaje> language) {
        this.language = language;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public List<TimeZone> getTimezone() {
        return timezone;
    }

    public void setTimezone(List<TimeZone> timezone) {
        this.timezone = timezone;
    }
    
    public Coordinate getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinate coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.isoCode);
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
        final Country other = (Country) obj;
        if (!Objects.equals(this.isoCode, other.isoCode)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Country{" + "name=" + name + ", isoCode=" + isoCode + ", language=" + language + ", currency=" + currency + ", timezone=" + timezone +", coordinates=" + coordinates + '}';
    }
}