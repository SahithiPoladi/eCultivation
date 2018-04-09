package com.sahi.registration;

/**
 * Created by Yashwanth on 3/3/2017.
 */

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class EloginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elogin);

        final EditText etmail = (EditText) findViewById(R.id.etmail);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bSignIn = (Button) findViewById(R.id.bSignIn);
        final TextView tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);

        tvRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(EloginActivity.this, EregisterActivity.class);
                EloginActivity.this.startActivity(registerIntent);
            }
        });

        bSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = etmail.getText().toString();
                final String password = etPassword.getText().toString();

                // Response received from the server
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                Intent intent = new Intent(EloginActivity.this, SearchActivity.class);
                                EloginActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(EloginActivity.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                EloginRequest eloginRequest = new EloginRequest(email, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(EloginActivity.this);
                queue.add(eloginRequest);
            }
        });
    }
}
