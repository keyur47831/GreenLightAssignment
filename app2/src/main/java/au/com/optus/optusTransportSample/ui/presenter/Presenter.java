package au.com.optus.optusTransportSample.ui.presenter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;

import au.com.optus.optusTransportSample.ui.view.MVPview;

/**
 * Created by k on 6/18/2016.
 */
public abstract class Presenter<V extends MVPview> {
    private V mView;

    public Presenter(@NonNull V view) throws  IllegalArgumentException {

        mView = view;

    }

    @NonNull
    protected V getView() {
        return mView;
    }


    protected Context getContext() {
        return mView.getContext();
    }


    public void onCreate(Bundle savedInstanceState) {
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
    }

    public void onDestroy() {
    }

    public void onStart() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onStop() {
    }

    public void onBackPressed() {
    }

    public void onOptionsItemSelected(MenuItem item) {

    }

    public void onClick(View view) {

    }

    public void onRestoreInstanceState(Bundle in) {
    }
}

