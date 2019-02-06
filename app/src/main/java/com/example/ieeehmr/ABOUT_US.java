package com.example.ieeehmr;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ABOUT_US extends AppCompatActivity {
    ImageView imageView;
    TextView num;
    private static final int REQUEST_CALL =1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__us);

        imageView=findViewById(R.id.imageCall);
        num=findViewById(R.id.num);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall();
            }
        });
    }
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==REQUEST_CALL){
            if(grantResults.length>0 &&grantResults[0]== PackageManager.PERMISSION_GRANTED) {
                makeCall();
            }

        }
    }

    private void makeCall() {
        String number=num.getText().toString();
        if(number.trim().length()>0){
            if(ContextCompat.checkSelfPermission(ABOUT_US.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(ABOUT_US.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);

            }else {
                String dial="tel:"+number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }

        }
    }
}
