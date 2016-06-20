package au.com.optus.optusTransportSample.manager;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.VisibleForTesting;

import au.com.optus.optusTransportSample.model.TransportMasterModel;
import au.com.optus.optusTransportSample.service.AsyncTaskCallback;
import au.com.optus.optusTransportSample.service.DataParseService;
import au.com.optus.optusTransportSample.service.DownloadService;
import au.com.optus.optusTransportSample.service.ServiceFactory;
import au.com.optus.optusTransportSample.util.Constants;

/**
 * Created by k
 */
public class DataManagerImpl implements DataManager, AsyncTaskCallback<Object> {

    private Context mContext;
    private static DataManagerImpl instance;
    private TransportMasterModel transportMasterModel;
    private static DownloadService downloadService;
    private static DataParseService dataParseServiceParseService;
    private Feedback feedback;


    @VisibleForTesting
    static DataManagerImpl getInstance(Context ctx, DownloadService ds, DataParseService dps) {
        if (instance == null) {
            instance = new DataManagerImpl(ctx);
        }
        downloadService = ds;
        dataParseServiceParseService = dps;
        return instance;
    }

    public static DataManagerImpl getInstance(Context ctx) {
        if (instance == null) {
            instance = new DataManagerImpl(ctx);
        }
        return instance;
    }

    private DataManagerImpl(Context context) {
        mContext = context;
        downloadService = DownloadService.getInstance(this);
        dataParseServiceParseService = DataParseService.getInstance(this);
    }

    @Override
    public void getServerData() {

        if (AsyncTask.Status.FINISHED.equals(downloadService.getStatus())) {
            downloadService = ServiceFactory.getDownloadService(this);
        }
        downloadService.execute(Constants.BASE_URL);
    }

    @Override
    public void getServerData(Feedback requestFeedback) {
        feedback = requestFeedback;
        if (AsyncTask.Status.FINISHED.equals(downloadService.getStatus())) {
            downloadService = ServiceFactory.getDownloadService(this);
        }
        downloadService.execute(Constants.BASE_URL);
    }

    @Override
    public void onTaskCompletedSuccess(Object result) {
        if (result instanceof TransportMasterModel) {
            dataParseServiceParseService = ServiceFactory.getForecastParseService(this);
            transportMasterModel = (TransportMasterModel) result;
            if (feedback != null) {
                feedback.success(result);
            }
        } else {
            //Start parsing in background thread
            dataParseServiceParseService.execute((String) result);
        }
    }

    @Override
    public void onTaskCompletedFailure(Object result) {
        feedback.error((String) result);
    }

    @Override
    public TransportMasterModel getTransportData() {
        return transportMasterModel;
    }


}
