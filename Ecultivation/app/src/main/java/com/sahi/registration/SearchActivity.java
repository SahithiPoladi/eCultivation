package com.sahi.registration;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by DELL on 6/1/2017.
 */

public class SearchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_search );

        final EditText etspec = (EditText) findViewById( R.id.etspec );
        final Button bsearch = (Button) findViewById( R.id.bsearch );

        bsearch.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String spec = etspec.getText().toString();

                // Response received from the server
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject( response );
                            boolean success = jsonResponse.getBoolean( "success" );

                            if (success) {
                                Intent intent = new Intent( SearchActivity.this, ImageActivity.class );
                                SearchActivity.this.startActivity( intent );
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder( SearchActivity.this );
                                builder.setMessage( "Login Failed" )
                                        .setNegativeButton( "Retry", null )
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

            }
        } );
    }
}
