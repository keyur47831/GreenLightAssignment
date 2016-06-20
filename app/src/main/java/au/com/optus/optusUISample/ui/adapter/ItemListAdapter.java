package au.com.optus.optusUISample.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import au.com.optus.optusUISample.R;
import au.com.optus.optusUISample.ui.view.OnInteractionListener;

/**
 * Created by k
 */
public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {
    private String[] mDataset;
    private OnInteractionListener onInteractionListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;

        public ViewHolder (View v) {
            super (v);
            mTextView = (TextView) v.findViewById (R.id.txtListItem);
        }
    }

    public ItemListAdapter (String[] data, OnInteractionListener callback) {
        onInteractionListener = callback;
        mDataset = data;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ItemListAdapter.ViewHolder onCreateViewHolder (ViewGroup parent,
                                                          int viewType) {
        // create a new view
        View v = LayoutInflater.from (parent.getContext ())
                .inflate (R.layout.item_top_list, parent, false);


        return new ViewHolder (v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder (final ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText (mDataset[position]);
        holder.mTextView.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                if (onInteractionListener != null)
                    onInteractionListener.onInteraction (mDataset[holder.getAdapterPosition ()]);
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount () {
        return mDataset.length;
    }
}
