package au.com.optus.optusTransportSample.ui.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import au.com.optus.optusTransportSample.R;
import au.com.optus.optusTransportSample.databinding.ActivityMainBinding;
import au.com.optus.optusTransportSample.model.MainActivityViewModel;
import au.com.optus.optusTransportSample.ui.adapter.LocationSpinnerAdapter;
import au.com.optus.optusTransportSample.ui.presenter.MainPresenter;
import au.com.optus.optusTransportSample.ui.view.MVPview;


public class MainActivity extends PresentableActivity<MainPresenter> implements MVPview {
    private ProgressDialog progressDialog;
    private ActivityMainBinding binding;
    private Spinner spinner;
    private MainActivityViewModel mainActivityViewModel;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        binding = DataBindingUtil.setContentView (this, R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(binding.toolbar);
        progressDialog = getPresenter ().prepareProgressDialog ();

    }

    @Override
    protected MainPresenter createPresenter () {
        return new MainPresenter (this);

    }

    @Override
    public Context getContext () {
        return this;
    }

    @Override
    public void showLoading () {
        progressDialog.show ();
    }

    @Override
    public void hideLoading () {
        progressDialog.cancel ();
    }

    @Override
    public void showToastMessage (String msg) {
        Toast.makeText (this, msg, Toast.LENGTH_LONG).show ();
    }

    @Override
    public void bindData (Object obj) {
        mainActivityViewModel = (MainActivityViewModel) obj;
        spinner = binding.spinnerLocation;
        binding.setViewModel (mainActivityViewModel);
        LocationSpinnerAdapter adapter = new LocationSpinnerAdapter (mainActivityViewModel.getTransportMasterModel ().getTransportDataModelList ());
        spinner.setAdapter (adapter);
        spinner.setSelection (mainActivityViewModel.getCurrentPosition ());
        spinner.setOnItemSelectedListener (getPresenter ());

    }



}
