package com.mindorks.tensorflowexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ThreeModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_three_model );

        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
    }
}
