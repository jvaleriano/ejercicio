package com.meli.ipcontextinfo.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class IpContextInfo {

    private String ip;
    private LocalDateTime date;
    private Country country;
    private Double distanceInKm;
    private Coordinate origin;

    public IpContextInfo() {
        this.date = LocalDateTime.now();
    }

    public IpContextInfo(String ip, LocalDateTime date, Country country, Double distanceInKm, Coordinate origin) {
        this.ip = ip;
        this.date = date;
        this.country = country;
        this.distanceInKm = distanceInKm;
        this.origin = origin;
    }

    public IpContextInfo(String ip, Country country, Double distanceInKm, Coordinate origin) {
        this.ip = ip;
        this.date = LocalDateTime.now();
        this.country = country;
        this.distanceInKm = distanceInKm;
        this.origin = origin;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Double getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(Double distanceInKm) {
        this.distanceInKm = distanceInKm;
    }

    public Coordinate getOrigin() {
        return origin;
    }

    public void setOrigin(Coordinate origin) {
        this.origin = origin;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.ip);
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
        final IpContextInfo other = (IpContextInfo) obj;
        if (!Objects.equals(this.ip, other.ip)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IpContextInfo{" + "ip=" + ip + ", date=" + date + ", country=" + country + ", distance=" + distanceInKm + ", origin=" + origin + '}';
    }

}
