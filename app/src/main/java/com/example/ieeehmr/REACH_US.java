package com.example.ieeehmr;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class REACH_US extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reach__us);
    }

    public void web(View view)
    {
        Intent browserIntent= new Intent(Intent.ACTION_VIEW, Uri.parse("http://sites.ieee.org/sb-hmritm/"));
        startActivity(browserIntent);

    }
}
