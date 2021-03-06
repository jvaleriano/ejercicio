package com.meli.ipcontextinfo.model;

import java.util.Objects;

/**
 *
 * @author jvaleriano
 */
public class Language {
    
    private String name;
    private String code;

    /**
     *
     * @param name
     * @param code
     */
    public Language(String name, String code) {
        this.name = name;
        this.code = code;
    }

    /**
     *
     */
    public Language() {
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.code);
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
        final Language other = (Language) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Languaje{" + "name=" + name + ", code=" + code + '}';
    }
    
    
    
}
