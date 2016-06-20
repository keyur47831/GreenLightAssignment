package au.com.optus.optusUISample.ui.adapter;

import org.junit.Test;
import org.junit.runner.RunWith;

import au.com.optus.optusUISample.OptusUISampleTestRunner;
import au.com.optus.optusUISample.ui.view.OnInteractionListener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by keyur on 06/21/16.
 */
@RunWith(OptusUISampleTestRunner.class)
public class ItemListAdapterTest {


    OnInteractionListener dummy = new OnInteractionListener () {
        @Override
        public void onInteraction (Object data) {

        }
    };

    @Test
    public void testItemListAdapterConstructor () throws Exception {
        String[] mockedList = new String[1];

        ItemListAdapter adapter = new ItemListAdapter (mockedList, dummy);
        assertNotNull (adapter);

    }

    @Test
    public void testGetItemCountForCodeCoverage () throws Exception {
        String[] mockedList = new String[2];

        ItemListAdapter adapter = new ItemListAdapter (mockedList, dummy);
        assertEquals (adapter.getItemCount (), mockedList.length);

    }

}