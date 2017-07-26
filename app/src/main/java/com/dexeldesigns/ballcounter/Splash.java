package com.dexeldesigns.ballcounter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.widget.FrameLayout;
import android.widget.VideoView;

/**
 * Created by Prakash on 7/26/2017.
 */

public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
       final VideoView videoView = (VideoView)findViewById(R.id.Videoview);

                 Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.splashvideo);
                videoView.setVideoURI(uri);
               videoView.setAlpha(0.5f);
                videoView.start();

        new Handler().postDelayed(new Runnable() {
            public void run() {



                Intent mainIntent = new Intent(
                        Splash.this,
                        MainActivity.class);

                Splash.this.startActivity(mainIntent);




            }
        }, 10000);

    }
}
