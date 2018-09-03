package com.meli.ipcontextinfo.service.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jvaleriano
 */
public class CountryRegionalBlocsDto {

    private String acronym;
    private String name;
    private List<String> otherAcronyms = new ArrayList< String>();
    private List< String> otherNames = new ArrayList< String>();

    public String getAcronym() {
        return acronym;
    }

    public String getName() {
        return name;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public void setName(String name) {
        this.name = name;
    }
}