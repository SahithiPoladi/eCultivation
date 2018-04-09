package com.sahi.registration;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.kosalgeek.android.photoutil.CameraPhoto;
import com.kosalgeek.android.photoutil.ImageBase64;
import com.kosalgeek.android.photoutil.ImageLoader;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.EachExceptionsHandler;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.HashMap;

/**
 * Created by DELL on 3/18/2017.
 */

public class ImageActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getName();

    ImageView ivCamera, ivUpload, ivImage;
    EditText ettext, etphone;
    CameraPhoto cameraPhoto;
    final int CAMERA_REQUEST = 13323;

    String selectedPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_image );

        cameraPhoto = new CameraPhoto( getApplicationContext() );

        ettext = (EditText) findViewById( R.id.ettext );
        etphone = (EditText) findViewById( R.id.etphone );
        ivCamera = (ImageView) findViewById( R.id.ivCamera );
        ivUpload = (ImageView) findViewById( R.id.ivUpload );
        ivImage = (ImageView) findViewById( R.id.ivImage );

        ivCamera.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    startActivityForResult( cameraPhoto.takePhotoIntent(), CAMERA_REQUEST );
                    cameraPhoto.addToGallery();
                } catch (IOException e) {
                    Toast.makeText( getApplicationContext(), "Something went wrong while clicking pictures", Toast.LENGTH_SHORT ).show();
                }
            }
        } );
        ivUpload.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Bitmap bitmap = ImageLoader.init().from( selectedPhoto ).requestSize( 1024, 1024 ).getBitmap();
                    String encodedImage = ImageBase64.encode( bitmap );
                    Log.d( TAG, encodedImage );

                    HashMap<String, String> postData = new HashMap<String, String>();
                    postData.put( "image", encodedImage );

                    PostResponseAsyncTask task = new PostResponseAsyncTask(ImageActivity.this, postData, new AsyncResponse(){
                        @Override
                        public void processFinish(String s){
                            if(s.contains("upload success")){
                                 Toast.makeText( getApplicationContext(),"Image uploaded successfully",Toast.LENGTH_SHORT ).show();
                            }
                            else{
                                Toast.makeText( getApplicationContext(),"Error while uploading",Toast.LENGTH_SHORT ).show();
                            }
                        }
                    });
                    task.execute("https://ecultivation.000webhostapp.com/upload.php");
                    task.setEachExceptionsHandler( new EachExceptionsHandler() {
                        @Override
                        public void handleIOException(IOException e) {
                            Toast.makeText( getApplicationContext(),"Cannot connect to server.",Toast.LENGTH_SHORT ).show();
                        }

                        @Override
                        public void handleMalformedURLException(MalformedURLException e) {
                            Toast.makeText( getApplicationContext(),"URL Error.",Toast.LENGTH_SHORT ).show();
                        }

                        @Override
                        public void handleProtocolException(ProtocolException e) {
                            Toast.makeText( getApplicationContext(),"Protocol Error.",Toast.LENGTH_SHORT ).show();
                        }

                        @Override
                        public void handleUnsupportedEncodingException(UnsupportedEncodingException e) {
                            Toast.makeText( getApplicationContext(),"Encoding Error.",Toast.LENGTH_SHORT ).show();
                        }
                    } );

                } catch (FileNotFoundException e) {
                    Toast.makeText( getApplicationContext(), "Something went wrong while encoding pictures", Toast.LENGTH_SHORT ).show();
                }
            }
        } );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == CAMERA_REQUEST) {
                String photoPath = cameraPhoto.getPhotoPath();
                selectedPhoto = photoPath;
                try {
                    Bitmap bitmap = ImageLoader.init().from( photoPath ).requestSize( 512, 512 ).getBitmap();
                    ivImage.setImageBitmap( bitmap );
                } catch (FileNotFoundException e) {
                    Toast.makeText( getApplicationContext(), "Something went wrong while loading pictures", Toast.LENGTH_SHORT ).show();
                }

            }
        }
    }

}


