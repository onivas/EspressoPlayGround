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
                new ItemDataSample("One", "1"),
                new ItemDataSample("Two", "2"),
                new ItemDataSample("Three", "3"),
                new ItemDataSample("Four", "3"),
                new ItemDataSample("Five", "3"),
                new ItemDataSample("Six", "4"),
                new ItemDataSample("Seven", "5"),
                new ItemDataSample("Eigth", "5"),
                new ItemDataSample("Nine", "6"),
                new ItemDataSample("Ten", "7"),
                new ItemDataSample("Eleven", "10"),
                new ItemDataSample("Twelve", "12"),
                new ItemDataSample("Thirteen", "13"),
                new ItemDataSample("Fourteen", "14")};

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
