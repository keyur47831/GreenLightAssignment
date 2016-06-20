package au.com.optus.optusUISample.ui.presenter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import au.com.optus.optusUISample.R;
import au.com.optus.optusUISample.model.HomeActivityViewModel;
import au.com.optus.optusUISample.ui.adapter.ItemListAdapter;
import au.com.optus.optusUISample.ui.adapter.ViewPagerAdapter;
import au.com.optus.optusUISample.ui.view.MVPview;
import au.com.optus.optusUISample.ui.view.OnInteractionListener;
import au.com.optus.optusUISample.utils.Constants;

/**
 * Created by k
 */
public class HomePresenter extends Presenter<MVPview> implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private String[] data = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
    private ImageView[] dots;
    private int dotCount;
    HomeActivityViewModel homeActivityViewModel;


    public HomePresenter (@NonNull MVPview view) {
        super (view);
    }

    @Override
    public void onStart () {

        homeActivityViewModel = new HomeActivityViewModel ();
        homeActivityViewModel.setItemListAdapter (new ItemListAdapter (data, recyclerInteractionListener));
        homeActivityViewModel.setViewPagerAdapter (new ViewPagerAdapter (getActivityFragmentManager (), viewPageInteractionListener));
        dotCount = homeActivityViewModel.getViewPagerAdapter ().getCount ();
        dots = new ImageView[dotCount];
        getView ().bindData (homeActivityViewModel);
        updateIndicator (0);
    }
    @Override
    public void onResume()
    {
        if(homeActivityViewModel!=null)
            getView ().updateView (homeActivityViewModel);
    }
    public void updateIndicator (int position) {
        LinearLayout linearLayout = new LinearLayout (getContext ());
        for (int i = 0; i < dotCount; i++) {
            dots[i] = new ImageView (getContext ());
            dots[i].setImageDrawable (ContextCompat.getDrawable (getContext (), R.drawable.nonselecteditem_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams (
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins (4, 0, 4, 0);

            linearLayout.addView (dots[i], params);
        }
        dots[position].setImageDrawable (ContextCompat.getDrawable (getContext (), R.drawable.selecteditem_dot));
        homeActivityViewModel.setLinearLayout (linearLayout);
        // getView ().bindData (homeActivityViewModel);
        getView ().updateView (homeActivityViewModel);
    }

    private OnInteractionListener viewPageInteractionListener = new OnInteractionListener () {
        @Override
        public void onInteraction (Object data) {
            String toastMessage = getContext ().getString (R.string.fragment_msg, data.toString ());
            getView ().showToastMessage (toastMessage);
        }
    };

    private OnInteractionListener recyclerInteractionListener = new OnInteractionListener () {
        @Override
        public void onInteraction (Object data) {
            homeActivityViewModel.setTopItemLabel (data.toString ());
        }
    };
    @Override
    public void onPageScrolled (int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected (int position) {
        updateIndicator (position);
    }


    @Override
    public void onPageScrollStateChanged (int state) {


    }

    @Override
    public void onClick (View view) {
        super.onClick (view);
        switch (view.getId ()) {
            case R.id.blueBtn:
                homeActivityViewModel.setBackGroundColor (Color.BLUE);
                break;
            case R.id.greenBtn:
                homeActivityViewModel.setBackGroundColor (Color.GREEN);
                break;
            case R.id.redBtn:
                homeActivityViewModel.setBackGroundColor (Color.RED);
                break;
        }
    }
    public void onSaveInstanceState(Bundle outState) {
       outState.putString (Constants.TITLE,homeActivityViewModel.getTopItemLabel ());
        outState.putInt (Constants.COLOR,homeActivityViewModel.getBackGroundColor ());
    }

    public void onRestoreInstanceState(Bundle inState) {
        if (inState != null) {
            homeActivityViewModel.setBackGroundColor (inState.getInt (Constants.COLOR));
            homeActivityViewModel.setTopItemLabel (inState.getString (Constants.TITLE));
        }
    }


}
