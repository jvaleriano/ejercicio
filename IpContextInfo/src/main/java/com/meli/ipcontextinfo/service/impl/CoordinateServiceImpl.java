package com.meli.ipcontextinfo.service.impl;

import com.meli.ipcontextinfo.command.CalculateDistanceCommand;
import com.meli.ipcontextinfo.model.Coordinate;
import com.meli.ipcontextinfo.service.CoordinateService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author VAL13448
 */
@Service
public class CoordinateServiceImpl implements CoordinateService{

    private final Coordinate origin;

    /**
     *  Latitud: -34.608318 | Longitud: -58.370288 (casa rosada)
     * @param originLat System variable injected by spring default: -34.608318
     * @param originLon System variable injected by spring default: -58.370288
     */
    public CoordinateServiceImpl(@Value("${origin.lat:-34.608318}") String originLat,
            @Value("${origin.lon:-58.370288}") String originLon) {
        this.origin = new Coordinate(Double.valueOf(originLat), Double.valueOf(originLon));
    }

    /**
     *
     * @param a 
     * @param b
     * @return
     */
    @Override
    public Double calculateDistanceInKm(Coordinate a, Coordinate b) {
        return new CalculateDistanceCommand(a, b).execute();

    }

    @Override
    public Double calculateDistanceToOriginInKm(Coordinate dest) {
        return calculateDistanceInKm(origin, dest);
    }

    @Override
    public Coordinate getOrigin() {
        return origin;
    }
    
}
