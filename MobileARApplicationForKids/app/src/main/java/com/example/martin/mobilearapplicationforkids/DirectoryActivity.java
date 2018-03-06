package com.example.martin.mobilearapplicationforkids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DirectoryActivity extends AppCompatActivity {
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);
        button2 = (Button) findViewById( R.id.button2 );
        button2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainAct = new Intent(DirectoryActivity.this, MainActivity.class);
                startActivity( mainAct );
            }
        } );
    }
}
