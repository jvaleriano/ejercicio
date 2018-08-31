package com.meli.ipcontextinfo.command;

import com.meli.ipcontextinfo.model.Coordinate;
import com.meli.ipcontextinfo.model.Country;
import com.meli.ipcontextinfo.model.CountryName;
import com.meli.ipcontextinfo.model.Currency;
import com.meli.ipcontextinfo.model.Languaje;
import com.meli.ipcontextinfo.model.TimeZone;
import com.meli.ipcontextinfo.service.model.CountryCurrencyDto;
import com.meli.ipcontextinfo.service.model.CountryDto;
import com.meli.ipcontextinfo.service.model.CountryLanguajeDto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VAL13448
 */
public class TransformDtoToCountryModelCommand implements Command<Country> {

    private final CountryDto countryDto;
    private final BigDecimal rate;

    public TransformDtoToCountryModelCommand(CountryDto countryDto, BigDecimal rate) {
        this.countryDto = countryDto;
        this.rate = rate;
    }

    @Override
    public Country execute() {
        CountryCurrencyDto currencyCode = countryDto.getCurrencies().iterator().next();
        Country country = new Country(new CountryName(countryDto.getName(),
                countryDto.getTranslations().get("es")), countryDto.getAlpha3Code(),
                parseLanguages(countryDto.getLanguages()),
                new Currency(currencyCode.getCode(), currencyCode.getSymbol(), rate),
                parseTimeZones(countryDto.getTimezones()),
                new Coordinate(Double.valueOf(countryDto.getLatlng().get(0)),
                        Double.valueOf(countryDto.getLatlng().get(1))));
        return country;
    }

    private List<TimeZone> parseTimeZones(List<String> timezones) {
        List<TimeZone> timeZones = new ArrayList<>();
        timezones.stream().forEach(a -> {
            timeZones.add(new TimeZone(a));
        });
        return timeZones;
    }

    private List<Languaje> parseLanguages(List<CountryLanguajeDto> languajesDto) {
        List<Languaje> languajes = new ArrayList<>();
        languajesDto.stream().forEach(a -> {
            languajes.add(new Languaje(a.getIso639_2(), a.getNativeName()));
        });
        return languajes;
    }

}
