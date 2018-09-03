package com.meli.ipcontextinfo.model;

import java.util.Objects;

/**
 *
 * @author jvaleriano
 */
public class Coordinate {

    private Double lat = Double.MIN_VALUE;
    private Double lon = Double.MIN_VALUE;

    /**
     *
     */
    public Coordinate() {
    }

    /**
     *
     * @param lat
     * @param lon
     */
    public Coordinate(Double lat, Double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    /**
     *
     * @return
     */
    public Double getLat() {
        return lat;
    }

    /**
     *
     * @param lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     *
     * @return
     */
    public Double getLon() {
        return lon;
    }

    /**
     *
     * @param lon
     */
    public void setLon(Double lon) {
        this.lon = lon;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.lat);
        hash = 67 * hash + Objects.hashCode(this.lon);
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
        final Coordinate other = (Coordinate) obj;
        if (!Objects.equals(this.lat, other.lat)) {
            return false;
        }
        if (!Objects.equals(this.lon, other.lon)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Coordinate{" + "lat=" + lat + ", lon=" + lon + '}';
    }
      
}