package au.com.optus.optusUISample.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.Color;
import android.widget.LinearLayout;

import au.com.optus.optusUISample.ui.adapter.ItemListAdapter;
import au.com.optus.optusUISample.ui.adapter.ViewPagerAdapter;


/**
 * Created by k
 */
public class HomeActivityViewModel extends BaseObservable {
    private ItemListAdapter itemListAdapter;
    private ViewPagerAdapter viewPagerAdapter;
    private String topItemLabel;
    private int backGroundColor = Color.WHITE;
    private LinearLayout linearLayout;

    public LinearLayout getLinearLayout () {
        return linearLayout;
    }

    public void setLinearLayout (LinearLayout linearLayout) {
        this.linearLayout = linearLayout;

    }

    public ItemListAdapter getItemListAdapter () {
        return itemListAdapter;
    }

    public void setItemListAdapter (ItemListAdapter itemListAdapter) {
        this.itemListAdapter = itemListAdapter;
    }

    public ViewPagerAdapter getViewPagerAdapter () {
        return viewPagerAdapter;
    }

    public void setViewPagerAdapter (ViewPagerAdapter viewPagerAdapter) {
        this.viewPagerAdapter = viewPagerAdapter;
    }


    public String getTopItemLabel () {
        return topItemLabel;
    }

    @Bindable
    public void setTopItemLabel (String topItemLabel) {
        this.topItemLabel = topItemLabel;
        notifyChange ();

    }


    public int getBackGroundColor () {
        return backGroundColor;
    }

    @Bindable
    public void setBackGroundColor (int backGroundColor) {
        this.backGroundColor = backGroundColor;
        notifyChange ();
    }
}
