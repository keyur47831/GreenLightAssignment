package au.com.optus.optusTransportSample.service;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;

import au.com.optus.optusTransportSample.model.TransportMasterModel;
import au.com.optus.optusTransportSample.util.Constants;
import au.com.optus.optusTransportSample.util.ParserUtil;

/**
 * Created by k
 */
public class DataParseService extends AsyncTask<String, String, Object> {
    private static final String TAG = DataParseService.class.getName ();
    private AsyncTaskCallback<Object> caller;

    public static DataParseService getInstance (AsyncTaskCallback<Object> caller) {
        return new DataParseService (caller);
    }

    private DataParseService (AsyncTaskCallback<Object> caller) {
        this.caller = caller;
    }

    @Override
    protected Object doInBackground (String... strings) {
        Log.d (TAG, "parsing starts in background");
        String jsonStr = strings[0];
        TransportMasterModel transportDataModels;

        try {
            transportDataModels = ParserUtil.parseTransportData (jsonStr);
        } catch (JSONException e) {
            return e;
        }
        return transportDataModels;
    }

    @Override
    protected void onPostExecute (Object result) {

        if (result instanceof TransportMasterModel) {
            caller.onTaskCompletedSuccess (result);
        } else {
            caller.onTaskCompletedFailure (Constants.PARSING_FAILED);
        }
    }
}
