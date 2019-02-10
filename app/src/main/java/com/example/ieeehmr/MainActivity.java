package com.example.ieeehmr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.ieee);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.animation);
        imageView.startAnimation(animation);
        Thread thread=new Thread()
        {
            public  void  run()
            {
                try {
                    sleep(1000);
                    Intent intent=new Intent(MainActivity.this,HOME.class);
                    startActivity(intent);
                }catch (InterruptedException e)
                {e.printStackTrace();}
            }
        };thread.start();
    }
}
