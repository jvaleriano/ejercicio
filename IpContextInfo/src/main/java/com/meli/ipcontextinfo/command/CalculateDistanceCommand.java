package com.meli.ipcontextinfo.command;

import com.meli.ipcontextinfo.model.Coordinate;

/**
 *
 * @author jvaleriano
 */
public class CalculateDistanceCommand implements Command<Double> {

    private final Coordinate a, b;

    /**
     *
     * @param a initial Coordinate 
     * @param b destiny Coordinate 
     * @see Coordinate
     */
    public CalculateDistanceCommand(Coordinate a, Coordinate b) {
        this.a = a;
        this.b = b;
    }

    /**
     *
     * @return Double represent the Distance in KM 
     * between Coordinate a and Coordinate b.
     * a or b are null return 0;
     */
    @Override
    public Double execute() {
        if(a == null || b == null){
            return 0d;
        }
        double radioTierra = 6371;//en kilómetros  
        double dLat = Math.toRadians(b.getLat() - a.getLat());
        double dLng = Math.toRadians(b.getLon() - a.getLon());
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(a.getLat())) * Math.cos(Math.toRadians(b.getLat()));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        double distancia = radioTierra * va2;
        return Math.round(distancia * 1000.0) / 1000.0;
    }

}
