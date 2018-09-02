package com.meli.ipcontextinfo.service.impl;

import com.meli.ipcontextinfo.command.TransformDtoToCountryCommand;
import com.meli.ipcontextinfo.model.Country;
import com.meli.ipcontextinfo.service.CountryService;
import com.meli.ipcontextinfo.service.CurrencyRateService;
import com.meli.ipcontextinfo.service.model.CountryDto;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

/**
 *
 * @author VAL13448
 */
@Service
public class CountryServiceImpl implements CountryService {

    private static final Logger LOG = Logger.getLogger(CountryServiceImpl.class.getName());

    @Autowired
    private CurrencyRateService rateService;
    
    private RestTemplate restTemplate = null;

    /**
     * Spring inject
     *
     * @param builder
     * @param url system parameter "url.restCountry" default value
     * https://restcountries.eu/rest/v2
     */
    public CountryServiceImpl(RestTemplateBuilder builder, @Value("${url.restCountry:https://restcountries.eu/rest/v2}") String url) {
        this.restTemplate = builder.build();
        this.restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(url));
    }

    /**
     *
     * @param isoCode
     * @return Country by ISO 3166-1 alpha-3 if invalid code null Link:
     * https://en.wikipedia.org/wiki/ISO_3166-1_alpha-3
     */
    @Override
    public Country getCountryByIsoCode(String isoCode) {
        try {
            CountryDto dto = getCountryDtoByIsoCode(isoCode);
            return new TransformDtoToCountryCommand(
                    dto,rateService.getCurrencyDolarRate(
                            dto.getCurrencies().iterator().next().getCode()))
                    .execute();
        } catch (RestClientException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;
    }

    /**
     *
     * @param isoCode
     * @return
     * @throws RestClientException
     */
    @Cacheable("isoCode")
    protected CountryDto getCountryDtoByIsoCode(String isoCode) throws RestClientException {
        return getRestTemplate().getForObject("/alpha/{isoCode}", CountryDto.class, isoCode);
    }

    /**
     *
     * @param rateService
     */
    public void setRateService(CurrencyRateService rateService) {
        this.rateService = rateService;
    }

    protected RestTemplate getRestTemplate() {
        return restTemplate;
    }
    
}