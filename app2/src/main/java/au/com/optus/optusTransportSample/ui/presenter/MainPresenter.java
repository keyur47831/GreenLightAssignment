package au.com.optus.optusTransportSample.ui.presenter;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import android.widget.AdapterView;

import java.util.Locale;

import au.com.optus.optusTransportSample.OptusTransportSampleApp;
import au.com.optus.optusTransportSample.R;
import au.com.optus.optusTransportSample.manager.DataManager;
import au.com.optus.optusTransportSample.manager.Feedback;
import au.com.optus.optusTransportSample.model.MainActivityViewModel;
import au.com.optus.optusTransportSample.model.TransportDataModel;
import au.com.optus.optusTransportSample.model.TransportMasterModel;
import au.com.optus.optusTransportSample.ui.view.MVPview;
import au.com.optus.optusTransportSample.util.Constants;
import au.com.optus.optusTransportSample.util.GenericParcelable;

/**
 * Created by k
 */
public class MainPresenter extends Presenter<MVPview> implements AdapterView.OnItemSelectedListener{

    @VisibleForTesting
    DataManager dataManager = OptusTransportSampleApp.getInstance ().getDataManager ();
    private MainActivityViewModel mainActivityViewModel;

    int oldIndex = -1;

    public MainPresenter (@NonNull MVPview view) {
        super (view);
    }


    @Override
    public void onResume () {
        if (mainActivityViewModel == null) {
            getView ().showLoading ();
            dataManager.getServerData (new Feedback<TransportMasterModel> () {

                @Override
                public void success (TransportMasterModel model) {
                    getView ().hideLoading ();
                    populateData (model);

                }

                @Override
                public void error (String errReason) {
                    getView ().hideLoading ();
                    getView ().showToastMessage (errReason);
                }
            });
        } else {
            setViewModelData (mainActivityViewModel.getCurrentPosition ());

        }

    }

    public ProgressDialog prepareProgressDialog () {
        ProgressDialog progressDialog = new ProgressDialog (getContext ());
        progressDialog.setIndeterminate (false);
        progressDialog.setProgressStyle (ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable (false);
        progressDialog.setMessage (getContext ().getString (R.string.loading));
        return progressDialog;
    }

    private void populateData (TransportMasterModel data) {
        mainActivityViewModel = new MainActivityViewModel ();
        mainActivityViewModel.setTransportMasterModel (data);
        bindAdapter ();

    }

    private void bindAdapter () {
        TransportDataModel item = mainActivityViewModel.getTransportMasterModel ().getTransportDataModelList ().get (0);
        if (item.getFromcentral ().getTrain () != null)
            mainActivityViewModel.setTrainData (getContext ().getString (R.string.train, item.getFromcentral ().getTrain ()));
        else
            mainActivityViewModel.setTrainData (null);
        if (item.getFromcentral ().getCar () != null)
            mainActivityViewModel.setCarData (getContext ().getString (R.string.car, item.getFromcentral ().getCar ()));
        else
            mainActivityViewModel.setCarData (null);
        mainActivityViewModel.setCurrentSelectedID (item.getId ());
        mainActivityViewModel.setCurrentPosition (0);
        getView ().bindData (mainActivityViewModel);
    }

    public void SpinnerClickHandler (Object data) {
        int currentIdex = (int) data;
        if (oldIndex != currentIdex) {
            setViewModelData (currentIdex);
        }
    }

    private void setViewModelData (int index) {
        TransportDataModel item = mainActivityViewModel.getTransportMasterModel ().getTransportDataModelList ().get (index);
        if (item.getFromcentral ().getTrain () != null)
            mainActivityViewModel.setTrainData (getContext ().getString (R.string.train, item.getFromcentral ().getTrain ()));
        else
            mainActivityViewModel.setTrainData (null);
        if (item.getFromcentral ().getCar () != null)
            mainActivityViewModel.setCarData (getContext ().getString (R.string.car, item.getFromcentral ().getCar ()));
        else
            mainActivityViewModel.setCurrentSelectedID (item.getId ());
        mainActivityViewModel.setCurrentPosition (index);
        oldIndex = index;
        getView ().bindData (mainActivityViewModel);
    }

    @SuppressWarnings("unchecked")
    public void onClick (final View view) {
        if ((int) view.getTag () != -1) {
            TransportDataModel item = getItemFromList ((int) view.getTag ());
            if (item != null) {
                String uri = String.format (Locale.getDefault (), "geo:%f,%f?z=17&q=%f,%f",
                        item.getLocation ().getLatitude (), item.getLocation ().getLongitude (), item.getLocation ().getLatitude (), item.getLocation ().getLongitude ());
                Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse (uri));
                getContext ().startActivity (intent);
            }
        }

    }


    private TransportDataModel getItemFromList (int index) {
        for (TransportDataModel item : mainActivityViewModel.getTransportMasterModel ().getTransportDataModelList ()) {
            if (index == item.getId ())
                return item;
        }
        return null;
    }

    @Override
    public void onSaveInstanceState (Bundle outState) {
        outState.putParcelable (Constants.SPINNER_DATA, new GenericParcelable<> (mainActivityViewModel));
    }

    @Override
    public void onRestoreInstanceState (Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            GenericParcelable<MainActivityViewModel>data=savedInstanceState.getParcelable (Constants.SPINNER_DATA);
            mainActivityViewModel = data.getValue ();
        }

    }
    @Override
    public void onItemSelected (AdapterView<?> adapterView, View view, int i, long l) {

        SpinnerClickHandler (i);

    }

    @Override
    public void onNothingSelected (AdapterView<?> adapterView) {

    }


}
