package au.com.optus.optusTransportSample.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import au.com.optus.optusTransportSample.OptusTransportSampleApp;
import au.com.optus.optusTransportSample.R;
import au.com.optus.optusTransportSample.model.TransportDataModel;

/**
 * Created by k
 */
public class LocationSpinnerAdapter extends BaseAdapter {
    ArrayList<TransportDataModel> data = null;


    public LocationSpinnerAdapter (ArrayList<TransportDataModel> data) {
        super ();
        this.data = data;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            //inflate your customlayout for the textview
            LayoutInflater inflater = (LayoutInflater) OptusTransportSampleApp.getInstance ().getSystemService (Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate (R.layout.spinner_item, parent, false);
        }
        //put the data in it
        final TransportDataModel item = data.get (position);
        if (item != null) {
            TextView text1 = (TextView) row.findViewById (R.id.txtSpinnerText);
            text1.setTextColor (Color.BLACK);
            text1.setText (item.getName ());
        }

        return row;
    }

    @Override
    public int getCount () {
        return data.size ();
    }


    @Override
    public TransportDataModel getItem (int position) {

        return data.get (position);
    }

    public ArrayList<TransportDataModel> getData () {
        return data;
    }

    @Override
    public long getItemId (int position) {

        return position;
    }


    public void setData (ArrayList<TransportDataModel> values) {
        data = values;
        notifyDataSetChanged ();
    }


}
