package au.com.optus.optusTransportSample.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.io.Serializable;

/**
 * Created by k
 */
public class MainActivityViewModel extends BaseObservable implements Serializable {
    TransportMasterModel transportMasterModel;
    String carData;
    String trainData;
    int currentSelectedID = -1;
    int currentPosition = -1;

    public MainActivityViewModel () {
        super ();
    }

    public String getCarData () {
        return carData;
    }

    @Bindable
    public void setCarData (String carData) {
        this.carData = carData;
        notifyChange ();
    }

    public String getTrainData () {
        return trainData;
    }

    @Bindable
    public void setTrainData (String trainData) {
        this.trainData = trainData;
        notifyChange ();
    }

    public TransportMasterModel getTransportMasterModel () {
        return transportMasterModel;
    }

    public void setTransportMasterModel (TransportMasterModel transportMasterModel) {
        this.transportMasterModel = transportMasterModel;
    }

    public int getCurrentSelectedID () {
        return currentSelectedID;
    }

    @Bindable
    public void setCurrentSelectedID (int currentSelectedID) {
        this.currentSelectedID = currentSelectedID;
        notifyChange ();
    }

    public int getCurrentPosition () {
        return currentPosition;
    }

    @Bindable
    public void setCurrentPosition (int currentPosition) {

        this.currentPosition = currentPosition;
        notifyChange ();
    }


}
