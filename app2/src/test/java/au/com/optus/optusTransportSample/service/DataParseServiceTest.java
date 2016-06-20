package au.com.optus.optusTransportSample.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by k .
 */

@RunWith(RobolectricTestRunner.class)
public class DataParseServiceTest {
    @Test
    public void testDataParseServiceAsyncTask() {
        TestAsync mockedAsyncTask = mock(TestAsync.class);
        DataParseService dps = DataParseService.getInstance(mockedAsyncTask);
        dps.execute("FakeStr");
        Robolectric.flushBackgroundThreadScheduler();
        verify(mockedAsyncTask, times(1)).onTaskCompletedFailure(any(String.class));
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