package com.example.tanvir.mindreader2;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.formats.NativeAdView;

public class MainActivity extends Activity {
    public Button button;
    private Handler mHandler = new Handler();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        

button=(Button)findViewById(R.id.button);



         mHandler.postDelayed(new Runnable() {

            public void run() {
                Intent intent = new Intent(MainActivity.this, Play.class);

                finish();
                startActivity(intent);

            }
        }, 3000);// 4 seconds
    }
}
