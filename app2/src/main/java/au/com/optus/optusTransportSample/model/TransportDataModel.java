package au.com.optus.optusTransportSample.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by k
 */

public class TransportDataModel implements Parcelable {

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

    @SuppressWarnings("unused")
    public TransportDataModel (Parcel in) {
        this ();
        readFromParcel (in);
    }

    private void readFromParcel (Parcel in) {
        this.setId (in.readInt ());
        this.setName (in.readString ());
        this.setLocation ((LocationModel) in.readValue (LocationModel.class.getClassLoader ()));
        this.setFromcentral ((FromCentralModel) in.readValue (FromCentralModel.class.getClassLoader ()));

        //  this.mDescription = in.readString();
        //   this.mLatitude = in.readDouble();
        //  this.mLongitude = in.readDouble();
    }

    public int describeContents () {
        return 0;
    }

    public static final Parcelable.Creator<TransportDataModel> CREATOR = new Parcelable.Creator<TransportDataModel> () {
        public TransportDataModel createFromParcel (Parcel in) {
            return new TransportDataModel (in);
        }

        public TransportDataModel[] newArray (int size) {
            return new TransportDataModel[size];
        }
    };


    @Override
    public void writeToParcel (Parcel dest, int flags) {
        // dest.writeString(mDescription);
        //  dest.writeDouble(mLatitude);
        //  dest.writeDouble(mLongitude);
        dest.writeInt (getId ());
        dest.writeString (getName ());
        dest.writeValue (getFromcentral ());
        dest.writeValue (getLocation ());
    }
}
