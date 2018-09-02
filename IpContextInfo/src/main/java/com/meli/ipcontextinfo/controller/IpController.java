package com.meli.ipcontextinfo.controller;

import com.meli.ipcontextinfo.model.Country;
import com.meli.ipcontextinfo.model.IpContextInfo;
import com.meli.ipcontextinfo.service.CoordinateService;
import com.meli.ipcontextinfo.service.CountryService;
import com.meli.ipcontextinfo.service.IpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ip")
public class IpController {
    
    @Autowired
    private IpService ipService;
    
    @Autowired
    private CountryService countryService;
    
    @Autowired
    private CoordinateService coordinateService;

    @RequestMapping("/trace")
    public ResponseEntity<IpContextInfo> trace(@RequestParam(value="ip") String ip) {
        String isoCode = ipService.getCountryCodeByIp(ip);
        if(!StringUtils.isEmpty(isoCode)){
            Country country = countryService.getCountryByIsoCode(isoCode);
            IpContextInfo toReturn = new IpContextInfo(ip, country,
                    coordinateService.calculateDistanceToOriginInKm(country.getCoordinates())
                    ,coordinateService.getOrigin());
            
            return new ResponseEntity<>(toReturn,HttpStatus.OK);
        }
        
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);  
    }

    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    public void setIpService(IpService ipService) {
        this.ipService = ipService;
    }

    public void setCoordinateService(CoordinateService coordinateService) {
        this.coordinateService = coordinateService;
    }
    
    
}
