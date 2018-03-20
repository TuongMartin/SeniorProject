package com.mindorks.tensorflowexample;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class CameraActivity extends AppCompatActivity {

    Camera camera;
    FrameLayout frameLayout;
    ShowCamera showCamera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_camera );

        getSupportActionBar().setDisplayHomeAsUpEnabled( true );

        frameLayout=(FrameLayout) findViewById(R.id.frameLayout);
        //open camera
        camera=Camera.open();
        showCamera=new ShowCamera(this, camera);
        frameLayout.addView(showCamera);


    }
}
