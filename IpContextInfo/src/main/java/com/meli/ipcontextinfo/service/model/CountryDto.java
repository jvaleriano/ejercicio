package com.meli.ipcontextinfo.service.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author VAL13448
 */
public class CountryDto {

    private String name;
    private List<String> topLevelDomain = new ArrayList< String>();
    private String alpha2Code;
    private String alpha3Code;
    private List<String> callingCodes = new ArrayList< String>();
    private String capital;
    private List<String> altSpellings = new ArrayList< String>();
    private String region;
    private String subregion;
    private float population;
    private List<String> latlng = new ArrayList< String>();
    private String demonym;
    private float area;
    private float gini;
    private List<String> timezones = new ArrayList< String>();
    private List<String> borders = new ArrayList< String>();
    private String nativeName;
    private String numericCode;
    private List<CountryCurrencyDto> currencies = new ArrayList< CountryCurrencyDto>();
    private List<CountryLanguajeDto> languages = new ArrayList< CountryLanguajeDto>();
    private Map<String, String> translations = new HashMap<>();
    private String flag;
    private List<CountryRegionalBlocsDto> regionalBlocs = new ArrayList<CountryRegionalBlocsDto>();
    private String cioc;

    @Override
    public String toString() {
        return "CountryDto{" + "name=" + name + ", topLevelDomain=" + topLevelDomain + ", alpha2Code=" + alpha2Code + ", alpha3Code=" + alpha3Code + ", callingCodes=" + callingCodes + ", capital=" + capital + ", altSpellings=" + altSpellings + ", region=" + region + ", subregion=" + subregion + ", population=" + population + ", latlng=" + latlng + ", demonym=" + demonym + ", area=" + area + ", gini=" + gini + ", timezones=" + timezones + ", borders=" + borders + ", nativeName=" + nativeName + ", numericCode=" + numericCode + ", currencies=" + currencies + ", languages=" + languages + ", translations=" + translations + ", flag=" + flag + ", regionalBlocs=" + regionalBlocs + ", cioc=" + cioc + '}';
    }
    
    // Getter Methods 
    public String getName() {
        return name;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public String getCapital() {
        return capital;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public float getPopulation() {
        return population;
    }

    public String getDemonym() {
        return demonym;
    }

    public float getArea() {
        return area;
    }

    public float getGini() {
        return gini;
    }

    public String getNativeName() {
        return nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public Map<String, String> getTranslations() {
        return translations;
    }

    public String getFlag() {
        return flag;
    }

    public String getCioc() {
        return cioc;
    }

    // Setter Methods 
    public void setName(String name) {
        this.name = name;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public void setPopulation(float population) {
        this.population = population;
    }

    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public void setGini(float gini) {
        this.gini = gini;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public void setTranslations(Map<String, String> translations) {
        this.translations = translations;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setCioc(String cioc) {
        this.cioc = cioc;
    }

    public List<CountryLanguajeDto> getLanguages() {
        return languages;
    }

    public void setLanguages(List<CountryLanguajeDto> languages) {
        this.languages = languages;
    }

    public List<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    public void setTopLevelDomain(List<String> topLevelDomain) {
        this.topLevelDomain = topLevelDomain;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(List<String> callingCodes) {
        this.callingCodes = callingCodes;
    }

    public List<String> getAltSpellings() {
        return altSpellings;
    }

    public void setAltSpellings(List<String> altSpellings) {
        this.altSpellings = altSpellings;
    }

    public List<String> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<String> latlng) {
        this.latlng = latlng;
    }

    public List<String> getTimezones() {
        return timezones;
    }

    public void setTimezones(List<String> timezones) {
        this.timezones = timezones;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public List<CountryCurrencyDto> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<CountryCurrencyDto> currencies) {
        this.currencies = currencies;
    }

    public List<CountryRegionalBlocsDto> getRegionalBlocs() {
        return regionalBlocs;
    }

    public void setRegionalBlocs(List<CountryRegionalBlocsDto> regionalBlocs) {
        this.regionalBlocs = regionalBlocs;
    }

    
}

class Translations {

    private String de;
    private String es;
    private String fr;
    private String ja;
    private String it;
    private String br;
    private String pt;
    private String nl;
    private String hr;
    private String fa;

    // Getter Methods 
    public String getDe() {
        return de;
    }

    public String getEs() {
        return es;
    }

    public String getFr() {
        return fr;
    }

    public String getJa() {
        return ja;
    }

    public String getIt() {
        return it;
    }

    public String getBr() {
        return br;
    }

    public String getPt() {
        return pt;
    }

    public String getNl() {
        return nl;
    }

    public String getHr() {
        return hr;
    }

    public String getFa() {
        return fa;
    }

    // Setter Methods 
    public void setDe(String de) {
        this.de = de;
    }

    public void setEs(String es) {
        this.es = es;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public void setJa(String ja) {
        this.ja = ja;
    }

    public void setIt(String it) {
        this.it = it;
    }

    public void setBr(String br) {
        this.br = br;
    }

    public void setPt(String pt) {
        this.pt = pt;
    }

    public void setNl(String nl) {
        this.nl = nl;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

    public void setFa(String fa) {
        this.fa = fa;
    }

}
