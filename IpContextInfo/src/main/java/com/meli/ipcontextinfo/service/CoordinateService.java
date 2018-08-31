package com.meli.ipcontextinfo.service;

import com.meli.ipcontextinfo.model.Coordinate;

/**
 *
 * @author VAL13448
 */
public interface CoordinateService {
    
    Double calculateDistanceInKm(Coordinate a, Coordinate b);
    
    Double calculateDistanceToOriginInKm(Coordinate dest);
    
    Coordinate getOrigin();
}
