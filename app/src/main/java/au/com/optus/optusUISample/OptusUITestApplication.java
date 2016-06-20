package au.com.optus.optusUISample;

import android.app.Application;

/**
 * Created by k
 */
public class OptusUITestApplication extends Application {


    private static OptusUITestApplication instance;

    public static OptusUITestApplication getInstance () {
        return OptusUITestApplication.instance;
    }

    @Override
    public void onCreate () {
        super.onCreate ();
        instance = this;

    }
}
