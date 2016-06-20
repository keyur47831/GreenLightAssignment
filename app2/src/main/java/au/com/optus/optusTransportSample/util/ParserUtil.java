package au.com.optus.optusTransportSample.util;

import android.support.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import au.com.optus.optusTransportSample.model.FromCentralModel;
import au.com.optus.optusTransportSample.model.LocationModel;
import au.com.optus.optusTransportSample.model.TransportDataModel;
import au.com.optus.optusTransportSample.model.TransportMasterModel;

/**
 * Created by k on 6/18/2016.
 */
public class ParserUtil {
    public static TransportMasterModel parseTransportData(@NonNull String transportJsonStr) throws JSONException {
        TransportMasterModel transportMasterModel = new TransportMasterModel();

        ArrayList<TransportDataModel> transportDataModel = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(transportJsonStr);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            TransportDataModel childData = new TransportDataModel();
            childData.setId(jsonObject.getInt(Constants.TAG_ID));
            childData.setName(jsonObject.getString(Constants.TAG_NAME));
            childData.setLocation(parseLocationModel(jsonObject.getJSONObject(Constants.TAG_LOCATION)));
            childData.setFromcentral(parseFromCentralModel(jsonObject.getJSONObject(Constants.TAG_FROM_CENTRAL)));
            transportDataModel.add(childData);

        }
        transportMasterModel.setTransportDataModelList(transportDataModel);
        return transportMasterModel;
    }

    public static LocationModel parseLocationModel(@NonNull JSONObject jsonObject) throws JSONException {
        LocationModel locationModel = new LocationModel();
        locationModel.setLatitude(jsonObject.optDouble(Constants.TAG_LATITUDE));
        locationModel.setLongitude(jsonObject.optDouble(Constants.TAG_LONGITUDE));
        return locationModel;
    }

    public static FromCentralModel parseFromCentralModel(@NonNull JSONObject jsonObject) throws JSONException {
        FromCentralModel fromCentralModelModel = new FromCentralModel();
        if (jsonObject.has(Constants.TAG_CAR))
            fromCentralModelModel.setCar(jsonObject.getString(Constants.TAG_CAR));
        if (jsonObject.has(Constants.TAG_TRAIN))
            fromCentralModelModel.setTrain(jsonObject.getString(Constants.TAG_TRAIN));
        return fromCentralModelModel;
    }
}
