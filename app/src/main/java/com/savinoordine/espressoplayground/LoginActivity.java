package com.savinoordine.espressoplayground;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity  extends ActionBarActivity {

    private EditText mEmailView;
    private EditText mPasswordView;
    private Button signInButton;

    private TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmailView = (EditText) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        error = (TextView) findViewById(R.id.error);

        signInButton = (Button) findViewById(R.id.email_sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mEmailView.getText().toString().equals("emailok@domain.it") &&
                        mPasswordView.getText().toString().equals("pwd")) {

                    // load new activity
                    Intent i = new Intent(getApplicationContext(), LoggedActivity.class);
                    startActivity(i);

                } else  {

                    error.setText(getString(R.string.fail_login_message));

                }
            }
        });
    }
}

