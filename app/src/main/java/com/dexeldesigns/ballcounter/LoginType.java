package com.dexeldesigns.ballcounter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.dexeldesigns.ballcounter.fingerprint.FingerprintActivity;

/**
 * Created by Creative IT Works on 27-Jul-17.
 */

public class LoginType extends AppCompatActivity {

    Button pin;
    ImageView image;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logintype);
        pin=(Button)findViewById(R.id.pin);
        image=(ImageView) findViewById(R.id.finger);

        pin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginType.this,PinLogin.class);
                startActivity(i);
                finish();
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    //Fingerprint API only available on from Android 6.0 (M)
                    FingerprintManager fingerprintManager = (FingerprintManager) LoginType.this.getSystemService(Context.FINGERPRINT_SERVICE);
                    if (ActivityCompat.checkSelfPermission(LoginType.this, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    if (!fingerprintManager.isHardwareDetected()) {
                        // Device doesn't support fingerprint authentication

                        Toast.makeText(getApplicationContext(),"Your Device not supported",Toast.LENGTH_SHORT).show();

                    } else if (!fingerprintManager.hasEnrolledFingerprints()) {
                        // User hasn't enrolled any fingerprints to authenticate with
                    } else {
                        // Everything is ready for fingerprint authentication

                        Intent i=new Intent(LoginType.this,FingerprintActivity.class);
                        startActivity(i);
                        finish();

                    }
                }


            }
        });

    }
}
