package com.ssru.toshihiro.mymonitor;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    Handler handler;
    Runnable runnable;
    long delay_time;
    long time = 3000;
    long time2 = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final MediaPlayer mediaPlayer1 = MediaPlayer.create(Splash.this, R.raw.start_up);
        mediaPlayer1.start();

        handler = new Handler();

        runnable = new Runnable() {


            @Override
            public void run() {
                Intent intent = new Intent(Splash.this , MainActivity.class);
                mediaPlayer1.stop();
                startActivity(intent);


                finish();
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        delay_time = time;
        handler.postDelayed(runnable, delay_time);
        time = System.currentTimeMillis();
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
        time = delay_time - (System.currentTimeMillis() - time);

    }
}
