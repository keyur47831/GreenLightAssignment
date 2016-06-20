package au.com.optus.optusUISample.ui.view;


import android.content.Context;
import android.support.v4.app.FragmentManager;

/**
 * Created by k
 */
public interface MVPview {
    Context getContext ();

    FragmentManager getActivityFragmentManager ();

    void showToastMessage (String msg);

    void bindData (Object data);

    void updateView (Object data);


}
