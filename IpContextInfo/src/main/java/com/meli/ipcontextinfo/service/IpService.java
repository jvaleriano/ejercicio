package com.meli.ipcontextinfo.service;

/**
 *
 * @author jvaleriano
 */
public interface IpService {

    /**
     *
     * @param ip
     * @return String ISO 3166-1 alpha-3 from a public ip if invalid ip null
     * Link: https://en.wikipedia.org/wiki/ISO_3166-1_alpha-
     */
    String getCountryCodeByIp(String ip);

}
