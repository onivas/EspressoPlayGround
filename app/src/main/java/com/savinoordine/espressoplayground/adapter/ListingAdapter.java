package com.savinoordine.espressoplayground.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.savinoordine.espressoplayground.R;
import com.savinoordine.espressoplayground.model.ItemDataSample;

public class ListingAdapter extends RecyclerView.Adapter<ListingAdapter.ViewHolder> {

    private ItemDataSample[] mDataset;

    @Override
    public ListingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_view_item, null);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset[position].getTitle());

    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.item_title);
        }
    }

    public ListingAdapter(ItemDataSample[] myDataset) {
        mDataset = myDataset;
    }
}
