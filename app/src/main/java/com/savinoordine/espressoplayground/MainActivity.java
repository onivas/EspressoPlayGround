package com.savinoordine.espressoplayground;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    Button toastButton;
    Button activityButton;
    Button listingButton;
    Button viewButton;
    Button loginButton;
    Button editButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toastButton = (Button) findViewById(R.id.button_toast);
        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), R.string.im_a_toast, Toast.LENGTH_SHORT)
                        .show();
            }
        });

        /*
        activityButton = (Button) findViewById(R.id.button__new_activity);
        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        */

        listingButton = (Button) findViewById(R.id.button_listing);
        listingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplication().getApplicationContext(), ListingActivity.class);
                startActivity(i);

            }
        });

        viewButton = (Button) findViewById(R.id.button_views);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplication().getApplicationContext(), ViewActivity.class);
                startActivity(i);

            }
        });

        loginButton = (Button) findViewById(R.id.button_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplication().getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });

        editButton = (Button) findViewById(R.id.button_edit);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplication().getApplicationContext(), EditActivity.class);
                startActivity(i);
            }
        });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_info:
                return true;
            case R.id.action_week:
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
