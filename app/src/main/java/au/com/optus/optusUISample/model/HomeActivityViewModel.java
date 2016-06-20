package au.com.optus.optusUISample.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
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
    private int backGroundColor = -1;

    public LinearLayout getLinearLayout() {
        return linearLayout;
    }

    public void setLinearLayout(LinearLayout linearLayout) {
        this.linearLayout = linearLayout;
    }

    private LinearLayout linearLayout;

    public ItemListAdapter getItemListAdapter() {
        return itemListAdapter;
    }

    public void setItemListAdapter(ItemListAdapter itemListAdapter) {
        this.itemListAdapter = itemListAdapter;
    }

    public ViewPagerAdapter getViewPagerAdapter() {
        return viewPagerAdapter;
    }

    public void setViewPagerAdapter(ViewPagerAdapter viewPagerAdapter) {
        this.viewPagerAdapter = viewPagerAdapter;
    }

    @Bindable
    public String getTopItemLabel() {
        return topItemLabel;
    }

    public void setTopItemLabel(String topItemLabel) {
        this.topItemLabel = topItemLabel;
        notifyChange();

    }

    @Bindable
    public int getBackGroundColor() {
        return backGroundColor;
    }

    public void setBackGroundColor(int backGroundColor) {
        this.backGroundColor = backGroundColor;
        notifyChange();
    }


}
