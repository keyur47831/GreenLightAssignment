package au.com.optus.optusTransportSample.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by k
 */
public class TransportMasterModel implements Serializable {
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

}
