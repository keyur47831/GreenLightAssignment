package au.com.optus.optusUISample.ui.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import au.com.optus.optusUISample.BuildConfig;
import au.com.optus.optusUISample.OptusUISampleTestRunner;
import au.com.optus.optusUISample.ui.activity.HomeActivity;

import static org.junit.Assert.*;

/**
 * Created by keyur on 06/20/16.
 */
@RunWith (RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class HomePresenterTest {
    HomeActivity homeActivity;
    @Before
    public void setUp () throws Exception {
     homeActivity= Robolectric.buildActivity (HomeActivity.class).create ().get ();
    }
    @Test
    public void testConstructor() throws Exception
    {
        HomePresenter homePresenter=new HomePresenter (homeActivity);
        assertNotNull (homePresenter);
    }
}