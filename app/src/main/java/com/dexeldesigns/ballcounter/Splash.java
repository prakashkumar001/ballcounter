package com.dexeldesigns.ballcounter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.widget.FrameLayout;
import android.widget.VideoView;

import com.dexeldesigns.ballcounter.fingerprint.FingerprintActivity;
import com.yqritc.scalablevideoview.ScalableVideoView;

import java.io.IOException;

/**
 * Created by Prakash on 7/26/2017.
 */

public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        final ScalableVideoView videoView = (ScalableVideoView) findViewById(R.id.Videoview);

        try {
            videoView.setRawData(R.raw.splash_video);
            videoView.setVolume(0, 0);
            videoView.setLooping(true);
            videoView.prepare(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    videoView.start();
                }
            });
        } catch (IOException ioe) {
            //ignore
        }

        new Handler().postDelayed(new Runnable() {
            public void run() {


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    //Fingerprint API only available on from Android 6.0 (M)
                    FingerprintManager fingerprintManager = (FingerprintManager) Splash.this.getSystemService(Context.FINGERPRINT_SERVICE);
                    if (ActivityCompat.checkSelfPermission(Splash.this, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }

                        Intent mainIntent = new Intent(
                                Splash.this,
                                FingerprintActivity.class);

                        Splash.this.startActivity(mainIntent);
                        finish();



                }




            }
        }, 6000);

    }
}
