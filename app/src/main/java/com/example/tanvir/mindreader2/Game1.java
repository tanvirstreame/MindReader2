package com.example.tanvir.mindreader2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Locale;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Game1 extends Activity  {


    public Button button3;
    public ImageView gif;
    TextView textView;
    public String s;
    public TextToSpeech tts;
    Animation an;


    int i = 0;
    float h;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game1);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        an= AnimationUtils.loadAnimation(this,R.anim.fade);



        tts = new TextToSpeech(Game1.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

            }
        });





        button3 = (Button) findViewById(R.id.button3);
        textView = (TextView) findViewById(R.id.textView);
        gif = (ImageView) findViewById(R.id.imageView2);
        textView.setAnimation(an);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random e = new Random();
                int y = e.nextInt(10) + 1;


                if (i <= 4) {
                    if (i == 1) {
                        h = (float) y / 2;
                        s = Float.toString(h);

                    }




                    if (i == 4) {
                        tts.setLanguage(Locale.US);
                        tts.speak(s, TextToSpeech.QUEUE_ADD, null);



                              button3.setVisibility(View.INVISIBLE);

                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                button3.setVisibility(View.VISIBLE);
                            }
                        }, 3000);


                    }


                    String a[] = {"Multiply with 2", "Add " + y, "Divide with 2", "Your total value - the thinked value", "Answer is " + h};
                    textView.startAnimation(an);
                    textView.setText(a[i]);



                }


                if (i == 5) {
                    Intent o = new Intent(Game1.this, Final.class);
                    tts.stop();
                    tts.shutdown();
                    finish();
                    startActivity(o);
                }

                i++;

            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }

}
