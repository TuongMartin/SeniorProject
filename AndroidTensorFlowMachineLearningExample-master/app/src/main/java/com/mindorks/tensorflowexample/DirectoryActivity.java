package com.mindorks.tensorflowexample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DirectoryActivity extends AppCompatActivity {
    private static final int INPUT_SIZE = 224;
    private static final int IMAGE_MEAN = 117;
    private static final float IMAGE_STD = 1;
    private static final String INPUT_NAME = "input";
    private static final String OUTPUT_NAME = "output";
    private static final String MODEL_FILE = "file:///android_asset/tensorflow_inception_graph.pb";
    private static final String LABEL_FILE =
            "file:///android_asset/imagenet_comp_graph_label_strings.txt";

    private Classifier classifier;
    private Executor executor = Executors.newSingleThreadExecutor();

    ImageView imageView;
    TextView nameResult;
    ImageButton imageButton1;
    ImageButton imageButton2;
    Uri imageUri;
    GridLayout idGrid;
    private static final int PICK_IMAGE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );

        imageButton1=(ImageButton) findViewById(R.id.imageButton1);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageView=(ImageView) findViewById(R.id.imageView);
        nameResult = (TextView) findViewById(R.id.nameResult);
        nameResult.setMovementMethod(new ScrollingMovementMethod());
        idGrid = (GridLayout) findViewById( R.id.idGrid );
        idGrid.setVisibility( idGrid.INVISIBLE );

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallary();
            }
        });
        imageButton2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detectImage();
            }
        } );

        initTensorFlowAndLoadModel();
    }

    private void detectImage() {
//       Bitmap bitmap = BitmapFactory.decodeResource( getResources(), R.drawable.sad);
        Bitmap bitmap= null;
        try {
            bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bitmap = Bitmap.createScaledBitmap( bitmap, 224,224, false );
        final List<Classifier.Recognition> results = classifier.recognizeImage(bitmap);
        nameResult.setText( results.toString() );
        idGrid.setVisibility( idGrid.VISIBLE );
    }

    private void openGallary(){
        Intent gallary=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallary,PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK && requestCode==PICK_IMAGE){
            imageUri=data.getData();
            imageView.setImageURI(imageUri);
        }
    }

    private void initTensorFlowAndLoadModel() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    classifier = TensorFlowImageClassifier.create(
                            getAssets(),
                            MODEL_FILE,
                            LABEL_FILE,
                            INPUT_SIZE,
                            IMAGE_MEAN,
                            IMAGE_STD,
                            INPUT_NAME,
                            OUTPUT_NAME);
                } catch (final Exception e) {
                    throw new RuntimeException("Error initializing TensorFlow!", e);
                }
            }
        });
    }

}

