package au.com.optus.optusTransportSample.manager;

import au.com.optus.optusTransportSample.model.TransportMasterModel;

/**
 * Created by k
 */
public interface DataManager {
    void getServerData();

    void getServerData(Feedback feedback);

    TransportMasterModel getTransportData();
}
