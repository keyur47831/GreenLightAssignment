package au.com.optus.optusTransportSample.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by k
 */
public class LocationModel implements Parcelable {
    private Double latitude;
    private Double longitude;

    public LocationModel() {
        super();
    }

    /**
     * @return The latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude The latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return The longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude The longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @SuppressWarnings("unused")
    public LocationModel(Parcel in) {
        this();
        readFromParcel(in);
    }

    private void readFromParcel(Parcel in) {
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();

    }

    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<LocationModel> CREATOR = new Parcelable.Creator<LocationModel>() {
        public LocationModel createFromParcel(Parcel in) {
            return new LocationModel(in);
        }

        public LocationModel[] newArray(int size) {
            return new LocationModel[size];
        }
    };


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // dest.writeString(mDescription);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
    }

}
