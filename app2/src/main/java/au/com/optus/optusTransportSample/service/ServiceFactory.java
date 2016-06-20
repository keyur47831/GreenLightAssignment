package au.com.optus.optusTransportSample.service;

/**
 * Created by k
 */
public class ServiceFactory {
    public static DownloadService getDownloadService (AsyncTaskCallback<Object> caller) {
        return DownloadService.getInstance (caller);
    }

    public static DataParseService getForecastParseService (AsyncTaskCallback<Object> caller) {
        return DataParseService.getInstance (caller);
    }
}
