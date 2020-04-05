package com.github.mehrdadf7.imagecropper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.github.mehrdadf7.imagecropper.cropper.CropImage;
import com.github.mehrdadf7.imagecropper.cropper.CropImageView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .start(this);

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                Log.e(TAG, "onActivityResult: " + resultUri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
                Log.e(TAG, "onActivityResult: " + error.toString());
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }




}
