package com.example.ieeehmr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class IEEE_BENIFITS extends YouTubeBaseActivity {
    ImageView imageView;

    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ieee__benifits);
        imageView=findViewById(R.id.playButton);

        youTubePlayerView = findViewById(R.id.youtubePlayerView);
        onInitializedListener= new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("wJyQwLfPtZ4");

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        youTubePlayerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.GONE);
                youTubePlayerView.initialize(playerConfig.API_KEY,onInitializedListener);
                Toast.makeText(IEEE_BENIFITS.this,"video is playing , MAKE SURE YOUR INTERNET CONNECTION IS ON",Toast.LENGTH_SHORT).show();
            }
        });

    }

}
