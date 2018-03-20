/*
 *    Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.mindorks.tensorflowexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
            }}
        );
        cameraButton = (ImageView) findViewById( R.id.cameraButton );
        cameraButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent modAct = new Intent(MainActivity.this, CameraActivity.class);
                startActivity( modAct );
            }}
        );
    }
}