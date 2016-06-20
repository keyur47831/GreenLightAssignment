package au.com.optus.optusTransportSample.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import au.com.optus.optusTransportSample.model.TransportMasterModel;
import au.com.optus.optusTransportSample.util.Constants;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by k
 */

@RunWith(RobolectricTestRunner.class)
public class DownloadServiceTest {
    @Test
    public void testDownloadAsyncTaskFail() {
        TestAsync mockedAsyncTask = mock(TestAsync.class);
        DownloadService ds = DownloadService.getInstance(mockedAsyncTask);
        ds.execute(Constants.BASE_URL+"test");
        Robolectric.flushBackgroundThreadScheduler();
        verify(mockedAsyncTask, times(1)).onTaskCompletedFailure(any(String.class));
    }
    @Test
    public void testDownloadAsyncTaskPass() {
        TestAsync mockedAsyncTask = mock(TestAsync.class);
        DownloadService ds = DownloadService.getInstance(mockedAsyncTask);
        ds.execute(Constants.BASE_URL);
        Robolectric.flushBackgroundThreadScheduler();
        verify(mockedAsyncTask, times(1)).onTaskCompletedSuccess(any(TransportMasterModel.class));
    }

    private class TestAsync implements AsyncTaskCallback<Object> {
        @Override
        public void onTaskCompletedSuccess(Object result) {

        }

        @Override
        public void onTaskCompletedFailure(Object result) {

        }
    }

}