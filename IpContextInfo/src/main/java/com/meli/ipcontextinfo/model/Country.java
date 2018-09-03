package com.meli.ipcontextinfo.model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author jvaleriano
 */
public class Country {

    private CountryName name;
    private String isoCode;
    private List<Language> language;
    private Currency currency;
    private List<TimeZone> timezone;
    private Coordinate coordinates;

    /**
     *
     */
    public Country() {
    }

    /**
     *
     * @param name
     * @param isoCode
     * @param language 
     * @param currency
     * @param timezone
     * @param coordinates
     * 
     * @see CountryName,Language, TimeZone
     */
    public Country(CountryName name, String isoCode, List<Language> language, Currency currency, List<TimeZone> timezone, Coordinate coordinates) {
        this.name = name;
        this.isoCode = isoCode;
        this.language = language;
        this.currency = currency;
        this.timezone = timezone;
        this.coordinates = coordinates;
    }
   
    /**
     *
     * @return
     */
    public CountryName getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(CountryName name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getIsoCode() {
        return isoCode;
    }

    /**
     *
     * @param isoCode
     */
    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    /**
     *
     * @return
     */
    public List<Language> getLanguage() {
        return language;
    }

    /**
     *
     * @param language
     */
    public void setLanguage(List<Language> language) {
        this.language = language;
    }

    /**
     *
     * @return
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     *
     * @param currency
     */
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    /**
     *
     * @return
     */
    public List<TimeZone> getTimezone() {
        return timezone;
    }

    /**
     *
     * @param timezone
     */
    public void setTimezone(List<TimeZone> timezone) {
        this.timezone = timezone;
    }
    
    /**
     *
     * @return
     */
    public Coordinate getCoordinates() {
        return coordinates;
    }

    /**
     *
     * @param coordinates
     */
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