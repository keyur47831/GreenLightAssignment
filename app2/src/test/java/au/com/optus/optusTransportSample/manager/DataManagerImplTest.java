package au.com.optus.optusTransportSample.manager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import au.com.optus.optusTransportSample.model.TransportMasterModel;
import au.com.optus.optusTransportSample.service.DataParseService;
import au.com.optus.optusTransportSample.service.DownloadService;
import au.com.optus.optusTransportSample.service.ServiceFactory;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by k
 */

@RunWith(RobolectricTestRunner.class)
public class DataManagerImplTest {

    @Mock
    private ServiceFactory mockedServiceFactory;

    @Mock
    private DownloadService mockedDownloadService;

    @Mock
    private DataParseService mockedParserService;

    private DataManagerImpl dataManager;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        dataManager = DataManagerImpl.getInstance(RuntimeEnvironment.application.getApplicationContext(),
                mockedDownloadService, mockedParserService);
    }

    @Test
    public void testGetCurrentWeatherData() {
        dataManager.getServerData();
        verify(mockedDownloadService, times(1)).execute(any(String.class));

    }

    @Test
    public void testOnTaskCompletedSuccessWithData() {
        TransportMasterModel mockedForecast = mock(TransportMasterModel.class);
        dataManager.onTaskCompletedSuccess(mockedForecast);
        assertEquals(dataManager.getTransportData(), mockedForecast);
    }

    @Test
    public void testOnTaskCompletedSuccessWithString() {
        dataManager.onTaskCompletedSuccess("DummyStr");
        verify(mockedParserService, times(1)).execute(any(String.class));
    }

}