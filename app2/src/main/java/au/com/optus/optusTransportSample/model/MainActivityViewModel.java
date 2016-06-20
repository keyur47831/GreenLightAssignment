package au.com.optus.optusTransportSample.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by k
 */
public class MainActivityViewModel extends BaseObservable implements Parcelable {
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
    }

    public String getTrainData () {
        return trainData;
    }

    @Bindable
    public void setTrainData (String trainData) {
        this.trainData = trainData;
    }

    public TransportMasterModel getTransportMasterModel () {
        return transportMasterModel;
    }

    public void setTransportMasterModel (TransportMasterModel transportMasterModel) {
        this.transportMasterModel = transportMasterModel;
    }

    //   public LocationSpinnerAdapter getLocationSpinnerAdapter () {
    //  return locationSpinnerAdapter;
    //  }

   /* @Bindable
    public void setLocationSpinnerAdapter (LocationSpinnerAdapter locationSpinnerAdapter) {
        this.locationSpinnerAdapter = locationSpinnerAdapter;
    }*/

    public int getCurrentSelectedID () {
        return currentSelectedID;
    }

    @Bindable
    public void setCurrentSelectedID (int currentSelectedID) {
        this.currentSelectedID = currentSelectedID;
    }

    public int getCurrentPosition () {
        return currentPosition;
    }

    @Bindable
    public void setCurrentPosition (int currentPosition) {
        this.currentPosition = currentPosition;
    }

    @SuppressWarnings("unused")
    public MainActivityViewModel (Parcel in) {
        this ();
        readFromParcel (in);
    }

    private void readFromParcel (Parcel in) {
        carData = in.readString ();
        trainData = in.readString ();
        //  locationSpinnerAdapter = (LocationSpinnerAdapter)in.readValue (LocationSpinnerAdapter.class.getClassLoader ());
        transportMasterModel = (TransportMasterModel) in.readValue (TransportMasterModel.class.getClassLoader ());

    }

    public int describeContents () {
        return 0;
    }

    public static final Parcelable.Creator<MainActivityViewModel> CREATOR = new Parcelable.Creator<MainActivityViewModel> () {
        public MainActivityViewModel createFromParcel (Parcel in) {
            return new MainActivityViewModel (in);
        }

        public MainActivityViewModel[] newArray (int size) {
            return new MainActivityViewModel[size];
        }
    };


    @Override
    public void writeToParcel (Parcel dest, int flags) {
        // dest.writeString(mDescription);
        dest.writeString (carData);
        dest.writeString (trainData);
        //   dest.writeValue (locationSpinnerAdapter);
        dest.writeValue (transportMasterModel);


    }

  /*  @BindingAdapter("bind:locationSpinnerAdapter")
    public static void LocationAdapterBinding (Spinner spinner, LocationSpinnerAdapter adapter) {
        spinner.setAdapter (adapter);

    }*/

   /* @BindingAdapter("bind:currentPosition")
    public static void LocationAdapterSelection (Spinner spinner, int index) {
        spinner.setOnItemSelectedListener(null);
        spinner.setSelection (index,true);
    }*/

}
