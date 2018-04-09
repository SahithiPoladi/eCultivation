package com.sahi.registration;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by Yashwanth on 3/2/2017.
 */

public class FarmerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_farmer );

        final EditText etfname = (EditText) findViewById( R.id.etfname );
        final EditText etlname = (EditText) findViewById( R.id.etlname );
        final EditText etage = (EditText) findViewById( R.id.etage );
        final EditText etyears = (EditText) findViewById( R.id.etyears );
        final EditText etnumber = (EditText) findViewById( R.id.etnumber );
        final EditText etgender = (EditText) findViewById( R.id.etgender );
        final EditText etvillage = (EditText) findViewById( R.id.etvillage );
        final EditText etdistrict = (EditText) findViewById( R.id.etdistrict );
        final EditText etpin = (EditText) findViewById( R.id.etpin );
        final EditText etacre1 = (EditText) findViewById( R.id.etacre1 );
        final EditText etacre2 = (EditText) findViewById( R.id.etacre2 );
        final EditText etirrigation = (EditText) findViewById( R.id.etirrigation );
        final EditText etpractice = (EditText) findViewById( R.id.etpractice );
        final EditText etname1 = (EditText) findViewById( R.id.etname1 );
        final EditText etvariety1 = (EditText) findViewById( R.id.etvariety1 );
        final EditText etyield1 = (EditText) findViewById( R.id.etyield1 );
        final EditText etname2 = (EditText) findViewById( R.id.etname2 );
        final EditText etvariety2 = (EditText) findViewById( R.id.etvariety2 );
        final EditText etyield2 = (EditText) findViewById( R.id.etyield2 );
        final EditText etname3 = (EditText) findViewById( R.id.etname3 );
        final EditText etvariety3 = (EditText) findViewById( R.id.etvariety3 );
        final EditText etyield3 = (EditText) findViewById( R.id.etyield3 );
        final EditText etname4 = (EditText) findViewById( R.id.etname4 );
        final EditText etvariety4 = (EditText) findViewById( R.id.etvariety4 );
        final EditText etyield4 = (EditText) findViewById( R.id.etyield4 );
        final EditText etname5 = (EditText) findViewById( R.id.etname5 );
        final EditText etvariety5 = (EditText) findViewById( R.id.etvariety5 );
        final EditText etyield5 = (EditText) findViewById( R.id.etyield5 );
        final Button bimage = (Button) findViewById(R.id.bimage);
        final Button bsubmit = (Button) findViewById( R.id.bsubmit );

        bimage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FarmerActivity.this, ImageActivity.class);
                FarmerActivity.this.startActivity(intent);
            }
        });

        bsubmit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String fname = etfname.getText().toString();
                final String lname = etlname.getText().toString();
                final int age = Integer.parseInt( etage.getText().toString() );
                final int years = Integer.parseInt( etyears.getText().toString() );
                final String phone = etnumber.getText().toString();
                final String gender = etgender.getText().toString();
                final String village = etvillage.getText().toString();
                final String district = etdistrict.getText().toString();
                final int pin = Integer.parseInt( etpin.getText().toString() );
                final int acre1 = Integer.parseInt( etacre1.getText().toString() );
                final int acre2 = Integer.parseInt( etacre2.getText().toString() );
                final String irrigation = etirrigation.getText().toString();
                final String practice = etpractice.getText().toString();
                final String name1 = etname1.getText().toString();
                final String variety1 = etvariety1.getText().toString();
                final String yield1 = etyield1.getText().toString();
                final String name2 = etname2.getText().toString();
                final String variety2 = etvariety2.getText().toString();
                final String yield2 = etyield2.getText().toString();
                final String name3 = etname3.getText().toString();
                final String variety3 = etvariety3.getText().toString();
                final String yield3 = etyield3.getText().toString();
                final String name4 = etname4.getText().toString();
                final String variety4 = etvariety4.getText().toString();
                final String yield4 = etyield4.getText().toString();
                final String name5 = etname5.getText().toString();
                final String variety5 = etvariety5.getText().toString();
                final String yield5 = etyield5.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Intent intent = new Intent( FarmerActivity.this, ImageActivity.class );
                        FarmerActivity.this.startActivity( intent );
                    }
                };

                FarmerRequest farmerRequest = new FarmerRequest( fname, lname, age, years, phone, gender, village, district, pin, acre1, acre2, irrigation, practice, name1, variety1, yield1, name2, variety2, yield2, name3, variety3, yield3, name4, variety4, yield4, name5, variety5, yield5, responseListener );
                RequestQueue queue = Volley.newRequestQueue( FarmerActivity.this );
                queue.add( farmerRequest );

            };
        } );
    }
}




