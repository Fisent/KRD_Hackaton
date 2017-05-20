package com.example.lukasz.krd_hackaton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lukasz.krd_hackaton.JavaClasses.MyTessOCR;

public class CaptureImage extends AppCompatActivity {


    Button btnTackPic;
    Uri photoPath;
    ImageView ivThumbnailPhoto;

    static int TAKE_PICTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_image);

        // Get reference to views

        ivThumbnailPhoto = (ImageView) findViewById(R.id.imageView1);
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, TAKE_PICTURE);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {


        if (requestCode == TAKE_PICTURE && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) intent.getExtras().get("data");
            ivThumbnailPhoto.setImageBitmap(photo);
            ivThumbnailPhoto.setVisibility(View.VISIBLE);
            MyTessOCR mTessOCR;
            mTessOCR=new MyTessOCR(CaptureImage.this);
            String temp = mTessOCR.getOCRResult(photo);
            TextView output = (TextView) findViewById(R.id.OCROutput);
            output.setText(temp);
        }

    }



}
