package au.com.optus.optusTransportSample.service;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import au.com.optus.optusTransportSample.model.TransportDataModel;
import au.com.optus.optusTransportSample.util.AppUtil;
import au.com.optus.optusTransportSample.util.Constants;

/**
 * Created by k
 */
public class DownloadService extends AsyncTask<String, String, Object> {

    private static final String TAG = DownloadService.class.getName ();
    private AsyncTaskCallback<Object> caller;

    public static DownloadService getInstance (AsyncTaskCallback<Object> caller) {
        return new DownloadService (caller);
    }

    private DownloadService (AsyncTaskCallback<Object> caller) {
        this.caller = caller;
    }

    @Override
    protected Object doInBackground (String... strings) {
        Log.d (TAG, "Starts downloading in background");
        String url = strings[0];
        String responseStr = "";
        TransportDataModel transportDataModel = null;

        try {
            responseStr = downloadData (url);
        } catch (IOException e) {
            Log.e (TAG, "Data download failed!!!", e);
            return e;
        }
        return responseStr;
    }

    @Override
    protected void onPostExecute (Object result) {
        if (result instanceof String) {
            caller.onTaskCompletedSuccess (result);
        } else {
            caller.onTaskCompletedFailure (Constants.DOWNLOAD_FAILED);
        }
    }

    private String downloadData (String requestUrl) throws IOException {
        InputStream inputStream;
        HttpURLConnection urlConnection;
        String resultStr = null;

        /* forming th java.net.URL object */
        URL url = new URL (requestUrl);
        urlConnection = (HttpURLConnection) url.openConnection ();

        /* optional request header */
        urlConnection.setRequestProperty ("Content-Type", "application/json");

        /* optional request header */
        urlConnection.setRequestProperty ("Accept", "application/json");

        /* for Get request */
        urlConnection.setRequestMethod ("GET");
        int statusCode = urlConnection.getResponseCode ();

        /* 200 represents HTTP OK */
        if (statusCode == 200) {
            inputStream = new BufferedInputStream (urlConnection.getInputStream ());
            resultStr = AppUtil.convertInputStreamToString (inputStream);
        }
        return resultStr;
    }

}
