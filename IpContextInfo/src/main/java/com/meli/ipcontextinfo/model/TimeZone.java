package com.meli.ipcontextinfo.model;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Objects;

/**
 *
 * @author VAL13448
 */
public class TimeZone {

    private ZoneId zoneId;

    public TimeZone(ZoneId zoneId) {
        this.zoneId = zoneId;
    }
    
    public TimeZone(String zoneId) {
        this.zoneId = ZoneId.of(zoneId);
    }
    
    public ZoneId getZoneId() {
        return zoneId;
    }

    public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }
    
    public LocalTime getTime() {
        return LocalTime.now(zoneId);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.zoneId);
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
        final TimeZone other = (TimeZone) obj;
        return true;
    }

    @Override
    public String toString() {
        return "TimeZone{" + "zoneId=" + zoneId + "time=" + getTime() + '}';
    }

    
    
    

}
