package com.example.martin.mobilearapplicationforkids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageButton;
    ImageView threeDButton;
    ImageView cameraButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton = (ImageView) findViewById( R.id.imageButton );
        imageButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dirAct = new Intent(MainActivity.this, DirectoryActivity.class);
                startActivity( dirAct );
            }
        } );
        threeDButton = (ImageView) findViewById( R.id.threeDButton );
        threeDButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent modAct = new Intent(MainActivity.this, ThreeModelActivity.class);
                startActivity( modAct );
            }
        }
        );
        cameraButton = (ImageView) findViewById( R.id.cameraButton );
        cameraButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent modAct = new Intent(MainActivity.this, CameraActivity.class);
                startActivity( modAct );
            }
        }
        );
    }
}
