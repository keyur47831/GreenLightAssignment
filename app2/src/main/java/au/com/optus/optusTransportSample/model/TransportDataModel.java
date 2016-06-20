package au.com.optus.optusTransportSample.model;

import java.io.Serializable;

/**
 * Created by k
 */

public class TransportDataModel implements Serializable {

    private Integer id;
    private String name;
    private FromCentralModel fromcentral;
    private LocationModel location;

    public TransportDataModel () {
        super ();
    }

    /**
     * @return The id
     */
    public Integer getId () {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId (Integer id) {
        this.id = id;
    }

    /**
     * @return The name
     */
    public String getName () {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName (String name) {
        this.name = name;
    }

    /**
     * @return The fromcentral
     */
    public FromCentralModel getFromcentral () {
        return fromcentral;
    }

    /**
     * @param fromcentral The fromcentral
     */
    public void setFromcentral (FromCentralModel fromcentral) {
        this.fromcentral = fromcentral;
    }

    /**
     * @return The location
     */
    public LocationModel getLocation () {
        return location;
    }

    /**
     * @param location The location
     */
    public void setLocation (LocationModel location) {
        this.location = location;
    }

}
