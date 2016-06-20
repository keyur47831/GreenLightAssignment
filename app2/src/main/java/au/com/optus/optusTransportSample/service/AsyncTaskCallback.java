package au.com.optus.optusTransportSample.service;

/**
 * Created by k
 */
public interface AsyncTaskCallback<T> {

    void onTaskCompletedSuccess (T result);

    void onTaskCompletedFailure (T result);
}