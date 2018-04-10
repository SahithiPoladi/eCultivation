package com.sahi.registration;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class VregisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vregister);

        final EditText etname = (EditText) findViewById(R.id.etname);
        final EditText etmail = (EditText) findViewById(R.id.etmail);
        final EditText etpassword = (EditText) findViewById(R.id.etpassword);
        final EditText etnumber = (EditText) findViewById(R.id.etnumber);
        final Button bregister = (Button) findViewById(R.id.bregister);

        bregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = etname.getText().toString();
                final String email = etmail.getText().toString();
                final String password = etpassword.getText().toString();
                final String phone = etnumber.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent villageintent = new Intent(VregisterActivity.this, VloginActivity.class);
                                VregisterActivity.this.startActivity(villageintent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(VregisterActivity.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                VregisterRequest vregisterRequest = new VregisterRequest(name, email, password, phone, responseListener);
                RequestQueue queue = Volley.newRequestQueue(VregisterActivity.this);
                queue.add(vregisterRequest);
            }
        });
    }
}
