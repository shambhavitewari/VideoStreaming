package com.example.a500061140.videostreaming;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView mainvideoView;
    private ImageView playbtn;
    private TextView currentTimer;
    private TextView durationTimer;
    private ProgressBar currentProgress;
    private ProgressBar bufferProgress;

    private Uri videoUri;
    private boolean isPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isPlaying= false;


        mainvideoView = (VideoView) findViewById(R.id.mainvideoView);
        playbtn= (ImageView) findViewById(R.id.playbtn);
        currentProgress = (ProgressBar) findViewById(R.id.currentProgress);
        currentTimer = (TextView) findViewById(R.id.currentTimer);
        durationTimer = (TextView) findViewById(R.id.durationTimer);
        bufferProgress = (ProgressBar)findViewById(R.id.bufferProgress)

        videoUri = uri.parse

         mainvideoView.setVideoURI(videoUri);
         mainvideoView.requestFocus();

         mainvideoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
             @Override
             public boolean onInfo(MediaPlayer mediaPlayer, int i, int i1) {

                 if(i == mediaPlayer.MEDIA_INFO_BUFFERING_START ) {

                     bufferProgress.setVisibility(view.VISIBLE);

                 } else if(i == mediaPlayer.MEDIA_INFO_BUFFERING_START)

                     bufferProgress.setVisibility();

                 return false;
             }
         });

         mainvideoView.start();
         isPlaying = true;
        playbtn.setImageResource(R.mipmap.ic_pause);

        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isPlaying){

                    mainvideoView.pause();
                    isPlaying = false;
                    playbtn.setImageResource(R.mipmap.ic_play_arrow);

                }

                else
                {
                    mainvideoView.start();
                    isPlaying = true;
                    playbtn.setImageResource(R.mipmap.ic_pause);
                }
            }
        });


    }
}
