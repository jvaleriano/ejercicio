package com.meli.ipcontextinfo.command;

import com.meli.ipcontextinfo.model.Coordinate;
import com.meli.ipcontextinfo.model.Country;
import com.meli.ipcontextinfo.model.CountryName;
import com.meli.ipcontextinfo.model.Currency;
import com.meli.ipcontextinfo.model.Language;
import com.meli.ipcontextinfo.model.TimeZone;
import com.meli.ipcontextinfo.service.model.CountryCurrencyDto;
import com.meli.ipcontextinfo.service.model.CountryDto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jvaleriano
 */
public class TransformDtoToCountryCommand implements Command<Country> {

    private final CountryDto countryDto;
    private final BigDecimal rate;

    /**
     *
     * @param countryDto CountryDto
     * @param rate BigDecimal
     * 
     *  Contain the logic to transform CountryDto in a Country
     * @see  CountryDto, Country
     *
     */
    public TransformDtoToCountryCommand(CountryDto countryDto, BigDecimal rate) {
        this.countryDto = countryDto;
        this.rate = rate;
    }

    @Override
    public Country execute() {
        if(countryDto == null)return new Country();
        CountryCurrencyDto currencyCode = parseCurrency();
        Country country = new Country(new CountryName(countryDto.getName(),
                countryDto.getTranslations() != null ? 
                        countryDto.getTranslations().get("es"):null),
                countryDto.getAlpha3Code(),
                parseLanguages(),
                new Currency(currencyCode.getCode(), currencyCode.getSymbol(), rate),
                parseTimeZones(), parseCoordinate());
        return country;
    }

    private CountryCurrencyDto parseCurrency() {
        CountryCurrencyDto currencyCode = countryDto.getCurrencies()!= null ?
                (countryDto.getCurrencies().iterator().hasNext() ?
                countryDto.getCurrencies().iterator().next():
                new CountryCurrencyDto() ):
                new CountryCurrencyDto();
        return currencyCode;
    }

    private Coordinate parseCoordinate() {
        if(countryDto.getLatlng() == null) return null;
        if(countryDto.getLatlng().size()< 2) return null;
        return new Coordinate(Double.valueOf(countryDto.getLatlng().get(0)),
                Double.valueOf(countryDto.getLatlng().get(1)));
    }

    private List<TimeZone> parseTimeZones() {
        List<TimeZone> timeZones = new ArrayList<>();
        if (countryDto.getTimezones() != null && !countryDto.getTimezones().isEmpty()) {
            countryDto.getTimezones().stream().forEach(a -> {
                timeZones.add(new TimeZone(a));
            });
        }
        return timeZones;
    }

    private List<Language> parseLanguages() {
        List<Language> languajes = new ArrayList<>();
        if(countryDto.getLanguages() != null && !countryDto.getLanguages().isEmpty()){
            countryDto.getLanguages().stream().forEach(a -> {
                languajes.add(new Language(a.getName(),a.getIso639_2()));
            });
           }
        return languajes;
    }

}
