package com.meli.ipcontextinfo.service;

import com.meli.ipcontextinfo.model.Coordinate;

/**
 *
 * @author jvaleriano
 */
public interface CoordinateService {

    /**
     *
     * @param a initial Coordinate
     * @param b destiny Coordinate
     * @see Coordinate
     * @return Double represent the Distance in KM between Coordinate a and
     * Coordinate b. a or b are null return 0;
     */
    Double calculateDistanceInKm(Coordinate a, Coordinate b);

    /**
     *
     * @param dest destiny Coordinate
     * @see Coordinate
     * @return Double represent the Distance in KM between Coordinate dest and
     * origin Latitud: -34.608318 | Longitud: -58.370288 (casa rosada).
     * if dest = null return 0;
     */
    Double calculateDistanceToOriginInKm(Coordinate dest);

    /**
     *
     * @return
     */
    Coordinate getOrigin();
}
