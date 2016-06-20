package au.com.optus.optusTransportSample.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by k on 6/18/2016.
 */
public class AppUtil {
    private final static String TAG = AppUtil.class.getName();
    public static String convertInputStreamToString(InputStream inputStream) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        String result = "";

        while ((line = bufferedReader.readLine()) != null) {
            result += line;
        }
            /* Close Stream */
        if (inputStream != null) {
            inputStream.close();
        }

        return result;
    }
}
