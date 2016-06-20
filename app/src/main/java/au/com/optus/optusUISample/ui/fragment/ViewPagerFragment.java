package au.com.optus.optusUISample.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import au.com.optus.optusUISample.R;
import au.com.optus.optusUISample.ui.view.OnInteractionListener;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ViewPagerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewPagerFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;


    private OnInteractionListener mListener;

    public ViewPagerFragment () {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment FirstFragment.
     */

    public static ViewPagerFragment newInstance (String param1) {
        ViewPagerFragment fragment = new ViewPagerFragment ();
        Bundle args = new Bundle ();
        args.putString (ARG_PARAM1, param1);


        fragment.setArguments (args);
        return fragment;
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setRetainInstance (true);
        if (getArguments () != null) {
            mParam1 = getArguments ().getString (ARG_PARAM1);
        }
    }

    public void setCallback (OnInteractionListener callback) {
        mListener = callback;
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate (R.layout.fragment_first, container, false);
        TextView fragmentText = (TextView) view.findViewById (R.id.txtFragmentNumber);
        fragmentText.setText (mParam1);
        fragmentText.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                if (mListener != null) {
                    mListener.onInteraction (mParam1);
                }

            }
        });
        return view;
    }

    @Override
    public void onAttach (Context context) {
        super.onAttach (context);
    }

    @Override
    public void onDetach () {
        super.onDetach ();
        mListener = null;
    }


}
