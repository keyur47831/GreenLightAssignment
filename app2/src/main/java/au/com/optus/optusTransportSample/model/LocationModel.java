package au.com.optus.optusTransportSample.model;

import java.io.Serializable;

/**
 * Created by k
 */
public class LocationModel implements Serializable {
    private Double latitude;
    private Double longitude;

    public LocationModel () {
        super ();
    }

    /**
     * @return The latitude
     */
    public Double getLatitude () {
        return latitude;
    }

    /**
     * @param latitude The latitude
     */
    public void setLatitude (Double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return The longitude
     */
    public Double getLongitude () {
        return longitude;
    }

    /**
     * @param longitude The longitude
     */
    public void setLongitude (Double longitude) {
        this.longitude = longitude;
    }
}
