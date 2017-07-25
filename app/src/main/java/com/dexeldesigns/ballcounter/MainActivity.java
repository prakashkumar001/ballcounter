package com.dexeldesigns.ballcounter;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.seismic.ShakeDetector;

public class MainActivity extends AppCompatActivity implements ShakeDetector.Listener{

    TextView balls,overs,wickets;
    float count=0.0f;
    int overscount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        ShakeDetector sd = new ShakeDetector(this);
        sd.start(sensorManager);
    }
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {
                    //TODO

                    if(count>0.4f)
                    {
                        count=0.0f;
                        overscount=overscount+1;
                        overs.setText(String.valueOf(overscount));
                    }else {
                        count=count+0.1f;
                    }

                    Log.i("BALL","BALL"+count);
                    balls.setText(String.format("%.1f", count));






                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    //TODO

                    if(count==0.0f)
                    {
                        count=0.0f;
                    }else {
                        count=count-0.1f;
                    }
                    Log.i("BALL","BALL"+count);
                    balls.setText(String.valueOf(String.format("%.1f", count)));

                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }


    }

    void init()
    {
        balls=(TextView)findViewById(R.id.ball);
        overs=(TextView)findViewById(R.id.overs);
        wickets=(TextView)findViewById(R.id.wickets);
    }

    @Override
    public void hearShake() {
        Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        v.vibrate(500);
        Toast.makeText(this, "Don't shake me, bro!", Toast.LENGTH_SHORT).show();

    }

    public abstract class DoubleClickListener implements View.OnClickListener {

        private static final long DOUBLE_CLICK_TIME_DELTA = 300;//milliseconds

        long lastClickTime = 0;

        @Override
        public void onClick(View v) {
            long clickTime = System.currentTimeMillis();
            if (clickTime - lastClickTime < DOUBLE_CLICK_TIME_DELTA) {
                onDoubleClick(v);
                lastClickTime = 0;
            } else {
                onSingleClick(v);
            }
            lastClickTime = clickTime;
        }

        public abstract void onSingleClick(View v);

        public abstract void onDoubleClick(View v);
    }



}
