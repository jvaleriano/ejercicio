package com.meli.ipcontextinfo.service.impl;

import com.meli.ipcontextinfo.service.IpService;
import com.meli.ipcontextinfo.service.model.Ip2CountryDto;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

/**
 *
 * @author jvaleriano
 */
@Service
public class IpServiceImpl implements IpService {

    private static final Logger LOG = Logger.getLogger(IpServiceImpl.class.getName());

    private RestTemplate restTemplate = null;

    /**
     * Spring inject 
     * @param builder
     * @param url system parameter "url.restIp2Country" default value https://api.ip2country.info
     */
    public IpServiceImpl(RestTemplateBuilder builder, @Value("${ipContextInfo.url.restIp2Country:https://api.ip2country.info}") String url) {
        this.restTemplate = builder.build();
        this.restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(url));
    }

    /**
     *
     * @param ip
     * @return String ISO 3166-1 alpha-3 from a public ip if invalid ip null
     * Link: https://en.wikipedia.org/wiki/ISO_3166-1_alpha-
     */
    @Override
    @Cacheable("ip")
    public String getCountryCodeByIp(String ip) {
        try {
            return getRestTemplate().getForObject("/ip?{ip}", Ip2CountryDto.class, ip).getCountryCode3();
        } catch (RestClientException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;
    }

    protected RestTemplate getRestTemplate() {
        return restTemplate;
    }
}
