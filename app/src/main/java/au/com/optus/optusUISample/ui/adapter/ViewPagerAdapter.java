package au.com.optus.optusUISample.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Locale;

import au.com.optus.optusUISample.ui.fragment.ViewPagerFragment;
import au.com.optus.optusUISample.ui.view.OnInteractionListener;
import au.com.optus.optusUISample.utils.Constants;

/**
 * Created by k
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private OnInteractionListener onInteractionListener;


    @Override
    public Fragment getItem (int pos) {

        ViewPagerFragment viewPagerFragment = ViewPagerFragment.newInstance (String.format (Locale.ENGLISH, Constants.FRAGMENT, pos + 1));
        viewPagerFragment.setCallback (onInteractionListener);
        return viewPagerFragment;
    }

    @Override
    public int getCount () {
        return Constants.MAX_FRAGMENTS;
    }

    public ViewPagerAdapter (FragmentManager fm, OnInteractionListener interactionListener) {
        super (fm);
        onInteractionListener = interactionListener;
    }
}
