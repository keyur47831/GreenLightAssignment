package au.com.optus.optusTransportSample.model;

import java.io.Serializable;

/**
 * Created by k
 */
public class FromCentralModel implements Serializable {
    private String car;
    private String train;

    public FromCentralModel () {
        super ();
    }

    /**
     * @return The car
     */
    public String getCar () {
        return car;
    }

    /**
     * @param car The car
     */
    public void setCar (String car) {
        this.car = car;
    }

    /**
     * @return The train
     */
    public String getTrain () {
        return train;
    }

    /**
     * @param train The train
     */
    public void setTrain (String train) {
        this.train = train;
    }
}
