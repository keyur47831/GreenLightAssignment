package au.com.optus.optusTransportSample;

import android.app.Application;

import au.com.optus.optusTransportSample.manager.DataManager;
import au.com.optus.optusTransportSample.manager.DataManagerImpl;

/**
 * Created by k
 */
public class OptusTransportSampleApp extends Application {
    private static OptusTransportSampleApp instance;
    private DataManager mDataManager;

    public static OptusTransportSampleApp getInstance () {
        return OptusTransportSampleApp.instance;
    }

    @Override
    public void onCreate () {
        super.onCreate ();
        instance = this;
        mDataManager = DataManagerImpl.getInstance (this);

    }

    public DataManager getDataManager () {
        return mDataManager;
    }
}
