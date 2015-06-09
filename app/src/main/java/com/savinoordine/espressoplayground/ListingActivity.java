package com.savinoordine.espressoplayground;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.savinoordine.espressoplayground.adapter.ListingAdapter;
import com.savinoordine.espressoplayground.model.ItemDataSample;


public class ListingActivity extends ActionBarActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        
        ItemDataSample ids[] = {
                new ItemDataSample("One"),
                new ItemDataSample("Two"),
                new ItemDataSample("Three"),
                new ItemDataSample("Four"),
                new ItemDataSample("Five"),
                new ItemDataSample("Six"),
                new ItemDataSample("Seven"),
                new ItemDataSample("Eigth"),
                new ItemDataSample("Nine"),
                new ItemDataSample("Ten"),
                new ItemDataSample("Eleven"),
                new ItemDataSample("Twelve"),
                new ItemDataSample("Thirteen"),
                new ItemDataSample("Fourteen")};

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new ListingAdapter(ids);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerView.setAdapter(mAdapter);
    }
}
