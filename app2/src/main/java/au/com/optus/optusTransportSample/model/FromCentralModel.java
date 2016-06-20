package au.com.optus.optusTransportSample.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by k
 */
public class FromCentralModel implements Parcelable {
    private String car;
    private String train;

    public FromCentralModel() {
        super();
    }

    /**
     * @return The car
     */
    public String getCar() {
        return car;
    }

    /**
     * @param car The car
     */
    public void setCar(String car) {
        this.car = car;
    }

    /**
     * @return The train
     */
    public String getTrain() {
        return train;
    }

    /**
     * @param train The train
     */
    public void setTrain(String train) {
        this.train = train;
    }

    @SuppressWarnings("unused")
    public FromCentralModel(Parcel in) {
        this();
        readFromParcel(in);
    }

    private void readFromParcel(Parcel in) {
        this.car = in.readString();
        this.train = in.readString();

    }

    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<FromCentralModel> CREATOR = new Parcelable.Creator<FromCentralModel>() {
        public FromCentralModel createFromParcel(Parcel in) {
            return new FromCentralModel(in);
        }

        public FromCentralModel[] newArray(int size) {
            return new FromCentralModel[size];
        }
    };


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // dest.writeString(mDescription);
        dest.writeString(car);
        dest.writeString(train);
    }


}
