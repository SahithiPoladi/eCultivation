package com.sahi.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button bfarmer = (Button) findViewById(R.id.bfarmer);
        final Button bvco = (Button) findViewById(R.id.bvco);
        final Button be = (Button) findViewById(R.id.be);

        bfarmer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        bvco.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, VloginActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        be.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EloginActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

    }
}
