package au.com.optus.optusUISample.ui.adapter;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import au.com.optus.optusUISample.BuildConfig;
import au.com.optus.optusUISample.ui.activity.HomeActivity;
import au.com.optus.optusUISample.ui.fragment.ViewPagerFragment;
import au.com.optus.optusUISample.ui.view.OnInteractionListener;
import au.com.optus.optusUISample.utils.Constants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

/**
 * Created by keyur on 06/21/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class ViewPagerAdapterTest {
    HomeActivity homeActivity;
    OnInteractionListener dummy = new OnInteractionListener () {
        @Override
        public void onInteraction (Object data) {

        }
    };

    @Before
    public void setUp () {
        homeActivity = Robolectric.setupActivity (HomeActivity.class);
    }

    @Test
    public void testConstructor () throws Exception {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter (homeActivity.getSupportFragmentManager (), dummy);
        assertNotNull (viewPagerAdapter);
    }

    @Test
    public void testItemCount () throws Exception {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter (homeActivity.getSupportFragmentManager (), dummy);
        assertNotNull (viewPagerAdapter);
        assertEquals (viewPagerAdapter.getCount (), Constants.MAX_FRAGMENTS);

    }

    @Test
    public void testGetItem () throws Exception {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter (homeActivity.getSupportFragmentManager (), dummy);
        assertNotNull (viewPagerAdapter.getItem (0));
    }


}