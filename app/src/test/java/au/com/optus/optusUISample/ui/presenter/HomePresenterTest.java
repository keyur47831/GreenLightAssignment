package au.com.optus.optusUISample.ui.presenter;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import au.com.optus.optusUISample.OptusUISampleTestRunner;
import au.com.optus.optusUISample.ui.activity.HomeActivity;

import static org.junit.Assert.*;

/**
 * Created by keyur on 06/20/16.
 */
@RunWith (OptusUISampleTestRunner.class)
public class HomePresenterTest {
    HomeActivity homeActivity;
    @Before
    public void setUp () throws Exception {
     homeActivity= Robolectric.buildActivity (HomeActivity.class).create ().get ();
    }
}