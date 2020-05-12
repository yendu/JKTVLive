package free.kashmir.jktvlive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
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
                        startActivity(intent);
                        //  intent.
                    }
                },duration);
            }
        });

    }
}
