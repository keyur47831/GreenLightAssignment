package au.com.optus.optusTransportSample.ui.adapter;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import au.com.optus.OptusTransportTestRunner;
import au.com.optus.optusTransportSample.model.TransportDataModel;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by k
 */

@RunWith(OptusTransportTestRunner.class)
public class LocationSpinnerAdapterTest {
    @Test
    @SuppressWarnings ("unchecked")
    public void testAdapterConstructor () throws Exception {
        ArrayList<TransportDataModel> mockedList = mock (ArrayList.class);
        LocationSpinnerAdapter pfa = new LocationSpinnerAdapter (mockedList);
        pfa.getCount ();
        verify (mockedList, times (1)).size ();
    }


    @Test
    public void testGetItemCountForCodeCoverage () throws Exception {
        ArrayList<TransportDataModel> dataList = new ArrayList<> ();
        dataList.add (mock (TransportDataModel.class));
        dataList.add (mock (TransportDataModel.class));
        LocationSpinnerAdapter pfa = new LocationSpinnerAdapter (dataList);
        assertEquals (2, pfa.getCount ());

    }

    @Test
    @SuppressWarnings ("unchecked")
    public void testAdapterItem () throws Exception {
        ArrayList<TransportDataModel> mockedList = mock (ArrayList.class);
        LocationSpinnerAdapter pfa = new LocationSpinnerAdapter (mockedList);
        pfa.getCount ();
        assertEquals (mockedList.get (0), pfa.getItem (0));
    }

    @Test
    public void testSetDataItem () throws Exception {
        ArrayList<TransportDataModel> dataList = new ArrayList<> ();
        dataList.add (mock (TransportDataModel.class));
        dataList.add (mock (TransportDataModel.class));
        LocationSpinnerAdapter pfa = new LocationSpinnerAdapter (dataList);

        dataList.add (mock (TransportDataModel.class));
        dataList.add (mock (TransportDataModel.class));
        pfa.setData (dataList);
        assertEquals (4, pfa.getCount ());
    }

    @Test
    public void testGetItemId () throws Exception {
        ArrayList<TransportDataModel> dataList = new ArrayList<> ();
        dataList.add (mock (TransportDataModel.class));
        dataList.add (mock (TransportDataModel.class));
        LocationSpinnerAdapter pfa = new LocationSpinnerAdapter (dataList);
        assertEquals (4, pfa.getItemId (4));
    }

}