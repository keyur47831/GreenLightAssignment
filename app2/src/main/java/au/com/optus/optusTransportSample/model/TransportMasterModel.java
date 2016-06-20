package au.com.optus.optusTransportSample.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by k
 */
public class TransportMasterModel implements Parcelable {
    ArrayList<TransportDataModel> transportDataModelList;

    public ArrayList<TransportDataModel> getTransportDataModelList () {
        return transportDataModelList;
    }

    public TransportMasterModel () {
        super ();
    }

    public void setTransportDataModelList (ArrayList<TransportDataModel> transportDataModelList) {
        this.transportDataModelList = transportDataModelList;
    }

    @SuppressWarnings("unused")
    public TransportMasterModel (Parcel in) {
        this ();
        readFromParcel (in);
    }

    private void readFromParcel (Parcel in) {
        ArrayList<TransportDataModel> data = new ArrayList<> ();
        in.readTypedList (data, TransportDataModel.CREATOR);
        transportDataModelList = data;

    }

    public int describeContents () {
        return 0;
    }

    public static final Parcelable.Creator<TransportMasterModel> CREATOR = new Parcelable.Creator<TransportMasterModel> () {
        public TransportMasterModel createFromParcel (Parcel in) {
            return new TransportMasterModel (in);
        }

        public TransportMasterModel[] newArray (int size) {
            return new TransportMasterModel[size];
        }
    };


    @Override
    public void writeToParcel (Parcel dest, int flags) {
        // dest.writeString(mDescription);
        dest.writeTypedList (transportDataModelList);
    }
}
