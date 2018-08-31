package com.meli.ipcontextinfo.service;

import com.meli.ipcontextinfo.model.Country;

/**
 *
 * @author VAL13448
 */
public interface CountryService {
    
    /**
     * 
     * @param isoCode
     * @return Country by ISO 3166-1 alpha-3 if invalid code null
     * Link: https://en.wikipedia.org/wiki/ISO_3166-1_alpha-3
     */
    Country getCountryByIsoCode(String isoCode);
    
}
