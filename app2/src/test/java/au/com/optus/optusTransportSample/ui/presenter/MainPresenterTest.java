package au.com.optus.optusTransportSample.ui.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import au.com.optus.optusTransportSample.BuildConfig;
import au.com.optus.optusTransportSample.ui.activity.MainActivity;

import static org.junit.Assert.assertNotNull;

/**
 * Created by keyur on 06/20/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainPresenterTest {
    MainActivity mainActivity;

    @Before
    public void setUp () throws Exception {
        mainActivity = Robolectric.buildActivity (MainActivity.class).create ().get ();


    }

    @Test
    public void testPresenterisNotNull () throws Exception {
        MainPresenter mainPresenter = new MainPresenter (mainActivity);
        assertNotNull (mainPresenter);
    }
}