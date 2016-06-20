package au.com.optus.optusTransportSample.ui.view;

import android.content.Context;

/**
 * Created by k on 6/18/2016.
 */
public interface MVPview {
    Context getContext();


     void showLoading();

     void hideLoading();

    void showToastMessage(String msg);

    void bindData(Object data);

}
