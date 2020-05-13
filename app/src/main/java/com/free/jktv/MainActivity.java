package com.free.jktv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    int duration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView=findViewById(R.id.videoView);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.jktv;
        videoView.setVideoURI(Uri.parse(path));



        if(savedInstanceState!=null){
            videoView.seekTo(savedInstanceState.getInt("currentTime"));

        }
//




        videoView.start();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                //Log.d("minuteDuration",String.valueOf(videoView.getDuration()));
                duration=videoView.getDuration();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                            Intent intent=new Intent(MainActivity.this,WebViewActivity.class);
                            intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                            startActivity(intent);
//                        webView.setVisibility(View.VISIBLE);
//                        videoView.setVisibility(View.GONE);
//                        videoView=null;
//                        webView.loadUrl("https://jktv.live/");
                        //  intent.
                    }
                },duration);
            }
        });

        }






    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
//        if(webView!=null){
//            webView.restoreState(savedInstanceState);
//        }


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("currentTime",videoView.getCurrentPosition());

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }





}
