package free.kashmir.jktvlive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;

import android.os.Bundle;

import android.widget.FrameLayout;

import com.rw.videowebview.VideoWebview;

public class WebViewActivity extends AppCompatActivity {



    VideoWebview videoWebview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        videoWebview = findViewById(R.id.webView);

        if(savedInstanceState==null){
            videoWebview.getWebView().loadUrl("https://jktv.live/");

            videoWebview.setFullScreenView(getSupportActionBar(), (FrameLayout) findViewById(R.id.fullscreen_view));
        }else{
            videoWebview.getWebView().restoreState(savedInstanceState);
        }


    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        videoWebview.getWebView().restoreState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        videoWebview.getWebView().saveState(outState);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

}

