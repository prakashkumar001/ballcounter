package com.dexeldesigns.ballcounter;

import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dexeldesigns.ballcounter.common.GlobalClass;
import com.dexeldesigns.ballcounter.umpire.TabPageActivity;
import com.squareup.seismic.ShakeDetector;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ShakeDetector.Listener{

    TextView balls,overs,wickets,currentrun;
    float count=0.0f;
    int overscount=0;
    int wicketcount=0;
    ImageView addwicket,removewicket;
    boolean doubleBackToExitPressedOnce = false;
    Button runs;
    ImageView text1,text2,text3,text4,text6,addball;
    GlobalClass global;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        global=(GlobalClass)getApplicationContext();
        init();
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        ShakeDetector sd = new ShakeDetector(this);
        sd.start(sensorManager);

        addwicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wicketcount=wicketcount+1;
                wickets.setText(String.valueOf(wicketcount));
                currentrun.setText(String.valueOf(global.Score)+"/"+String.valueOf(wicketcount));

            }
        });

        addball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                currentrun.setText(String.valueOf(global.Score)+"/"+String.valueOf(wicketcount));


            }
        });

        removewicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(wicketcount==0)
                {
                    Toast.makeText(MainActivity.this,"You cant remove wickets",Toast.LENGTH_SHORT).show();
                }else {
                    wicketcount=wicketcount-1;
                }
                wickets.setText(String.valueOf(wicketcount));
                currentrun.setText(String.valueOf(global.Score)+"/"+String.valueOf(wicketcount));

            }
        });
        runs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showrundialog();
            }
        });
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
        currentrun=(TextView)findViewById(R.id.currentrun);
        addwicket=(ImageView) findViewById(R.id.addwicket);
        removewicket=(ImageView) findViewById(R.id.removewicket);
        runs=(Button) findViewById(R.id.runs);
        text1=(ImageView)findViewById(R.id.text1);
        text2=(ImageView)findViewById(R.id.text2);
        text3=(ImageView)findViewById(R.id.text3);
        text4=(ImageView)findViewById(R.id.text4);
        text6=(ImageView)findViewById(R.id.text6);
        addball=(ImageView)findViewById(R.id.addball);

    }









    @Override
    public void hearShake() {
        Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        v.vibrate(500);

        if(wicketcount<=9)
        {
            wicketcount=wicketcount+1;
            wickets.setText(String.valueOf(wicketcount));
            currentrun.setText(String.valueOf(global.Score)+"/"+String.valueOf(wicketcount));

        }


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



    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            global.Score=0;
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    public void showrundialog() {

        // custom dialog
        final Dialog dialog = new Dialog(MainActivity.this, R.style.DialogSlideAnim);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.run_dialog);
        dialog.getWindow().setGravity(Gravity.CENTER);
        //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        DisplayMetrics metrics = getApplicationContext().getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        dialog.show();
        dialog.getWindow().setLayout((7 * width) / 10, (7 * height) / 10);

        ImageView imageView1=(ImageView)dialog.findViewById(R.id.text1);
        ImageView imageView2=(ImageView)dialog.findViewById(R.id.text2);
        ImageView imageView3=(ImageView)dialog.findViewById(R.id.text3);
        ImageView imageView4=(ImageView)dialog.findViewById(R.id.text4);
        ImageView imageView6=(ImageView)dialog.findViewById(R.id.text6);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                global.Score=global.Score+1;
                currentrun.setText(String.valueOf(global.Score)+"/"+String.valueOf(wicketcount));

                dialog.dismiss();

            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                global.Score=global.Score+2;
                currentrun.setText(String.valueOf(global.Score)+"/"+String.valueOf(wicketcount));

                dialog.dismiss();

            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                global.Score=global.Score+3;
                currentrun.setText(String.valueOf(global.Score)+"/"+String.valueOf(wicketcount));

                dialog.dismiss();

            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                global.Score=global.Score+4;
                currentrun.setText(String.valueOf(global.Score)+"/"+String.valueOf(wicketcount));

                dialog.dismiss();

            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                global.Score=global.Score+6;
                currentrun.setText(String.valueOf(global.Score)+"/"+String.valueOf(wicketcount));
                dialog.dismiss();
            }
        });
        dialog.show();


    }

}
