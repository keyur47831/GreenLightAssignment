package au.com.optus.optusUISample.ui.activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import au.com.optus.optusUISample.R;


import au.com.optus.optusUISample.databinding.ActivityHomeBinding;
import au.com.optus.optusUISample.model.HomeActivityViewModel;
import au.com.optus.optusUISample.ui.presenter.HomePresenter;
import au.com.optus.optusUISample.ui.view.MVPview;
import au.com.optus.optusUISample.ui.view.WrapContentHeightViewPager;
import au.com.optus.optusUISample.utils.Constants;


public class HomeActivity extends PresentableActivity<HomePresenter> implements MVPview ,View.OnClickListener{

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private WrapContentHeightViewPager wrapContentHeightViewPager;
    private HomeActivityViewModel homeActivityViewModel;
    private LinearLayout indicatorLayout;
    private ActivityHomeBinding binding;
    private Parcelable recyclerViewdata;
    private Parcelable viewPagerData;

    @NonNull
    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        recyclerView = binding.itemList;
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        setSupportActionBar(binding.toolbar);

        wrapContentHeightViewPager =binding.itemViewPager;
        wrapContentHeightViewPager.addOnPageChangeListener(getPresenter ());
        indicatorLayout = binding.viewPagerCountDots;

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public FragmentManager getActivityFragmentManager() {
        return getSupportFragmentManager();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (recyclerViewdata != null) {
            layoutManager.onRestoreInstanceState(recyclerViewdata);

        }
        if(viewPagerData!=null)
            wrapContentHeightViewPager.onRestoreInstanceState(viewPagerData);
    }

    @Override
    public void showToastMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void bindData(Object data) {

        homeActivityViewModel = (HomeActivityViewModel) data;
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(homeActivityViewModel.getItemListAdapter());
        wrapContentHeightViewPager.setAdapter(homeActivityViewModel.getViewPagerAdapter());
        binding.setViewModel(homeActivityViewModel);


    }

    private void updateDotIndicator() {
        indicatorLayout.removeAllViews();
        indicatorLayout.addView(homeActivityViewModel.getLinearLayout());
    }

    @Override
    public void updateView(Object data) {
        HomeActivityViewModel presenterData=(HomeActivityViewModel) data;
        homeActivityViewModel.setBackGroundColor (presenterData.getBackGroundColor ());
        homeActivityViewModel.setTopItemLabel (presenterData.getTopItemLabel ());
        homeActivityViewModel.setLinearLayout (presenterData.getLinearLayout ());
        updateDotIndicator();
    }



    public void onSaveInstanceState(Bundle outState) {
        recyclerViewdata = layoutManager.onSaveInstanceState();
        outState.putParcelable(Constants.RECYLER_DATA, recyclerViewdata);
        viewPagerData = wrapContentHeightViewPager.onSaveInstanceState();
        outState.putParcelable(Constants.VIEW_PAGER_DATA, viewPagerData);
        getPresenter ().onSaveInstanceState (outState);
    }

    public void onRestoreInstanceState(Bundle inState) {
        if (inState != null) {
            recyclerViewdata = inState.getParcelable(Constants.RECYLER_DATA);
            viewPagerData = inState.getParcelable(Constants.VIEW_PAGER_DATA);
            getPresenter ().onRestoreInstanceState (inState);

        }
    }


}
