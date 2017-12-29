package com.dexeldesigns.ballcounter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Creative IT Works on 27-Jul-17.
 */

public class PinLogin extends AppCompatActivity {
    ImageView text1,text2,text3,text4,text5,text6,text7,text8,text9;
    ImageView erase,delete,login,back;
    ImageView i1, i2, i3, i4;
    // EditText input_number;
    String userId="",uiPwd="";
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pin);
        initialize();
    }
    private void initialize()
    {
        text1=(ImageView)findViewById(R.id.text1);
        text2=(ImageView)findViewById(R.id.text2);
        text3=(ImageView)findViewById(R.id.text3);
        text4=(ImageView)findViewById(R.id.text4);
        text5=(ImageView)findViewById(R.id.text5);
        text6=(ImageView)findViewById(R.id.text6);
        text7=(ImageView)findViewById(R.id.text7);
        text8=(ImageView)findViewById(R.id.text8);
        text9=(ImageView)findViewById(R.id.text9);
        erase=(ImageView)findViewById(R.id.erase);
        delete=(ImageView)findViewById(R.id.delete);
        //input_number=(EditText)findViewById(R.id.pin_number);
        i1 = (ImageView) findViewById(R.id.imageview_circle1);
        i2 = (ImageView) findViewById(R.id.imageview_circle2);
        i3 = (ImageView) findViewById(R.id.imageview_circle3);
        i4 = (ImageView) findViewById(R.id.imageview_circle4);

        // enter=(Button) findViewById(R.id.enter);


    }

    public void enterPin(View view)
    {

        ImageView clickedButton = (ImageView)view;
        if(clickedButton.getId() == erase.getId())
        {

            if(userId.length() > 0)
            {
                uiPwd = "";
                userId = "";

            }
            passCode();
        }
        else if(clickedButton.getId() == delete.getId())
        {

            if(userId.length() > 0)
            {
                uiPwd = uiPwd.substring(0,uiPwd.length()-1);
                userId = userId.substring(0,userId.length()-1);
            }
            passCode();

        }
        else
        {
            uiPwd = uiPwd + ".";
            userId = userId+clickedButton.getTag().toString();

            passCode();

        }
        //input_number.setText(uiPwd);



        //test();

    }




    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
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

    public void passCode(){
        if(userId.toString().length()==0)
        {
            i1.setImageResource(R.drawable.ic_pin_unselect);
            i2.setImageResource(R.drawable.ic_pin_unselect);
            i3.setImageResource(R.drawable.ic_pin_unselect);
            i4.setImageResource(R.drawable.ic_pin_unselect);

        }
        else if(userId.toString().length()==1)
        {
            i1.setImageResource(R.drawable.ball);
            i2.setImageResource(R.drawable.ic_pin_unselect);
            i3.setImageResource(R.drawable.ic_pin_unselect);
            i4.setImageResource(R.drawable.ic_pin_unselect);

        }else if(userId.toString().length()==2)
        {
            i1.setImageResource(R.drawable.ball);
            i2.setImageResource(R.drawable.ball);
            i3.setImageResource(R.drawable.ic_pin_unselect);
            i4.setImageResource(R.drawable.ic_pin_unselect);

        }else if(userId.toString().length()==3)
        {
            i1.setImageResource(R.drawable.ball);
            i2.setImageResource(R.drawable.ball);
            i3.setImageResource(R.drawable.ball);
            i4.setImageResource(R.drawable.ic_pin_unselect);

        }else if(userId.toString().length()==4)
        {
            i1.setImageResource(R.drawable.ball);
            i2.setImageResource(R.drawable.ball);
            i3.setImageResource(R.drawable.ball);
            i4.setImageResource(R.drawable.ball);

            if(userId.equalsIgnoreCase("1234") )
            {

                Intent i=new Intent(PinLogin.this,MainActivity.class);
                startActivity(i);
                finish();

            }else {
                onShakeImage();
            }


        }else if(userId.length()>4){
            onShakeImage();
            userId=userId.substring(0,userId.length()-1);
            i1.setImageResource(R.drawable.ic_pin_select);
            i2.setImageResource(R.drawable.ic_pin_select);
            i3.setImageResource(R.drawable.ic_pin_select);
            i4.setImageResource(R.drawable.ic_pin_select);

        }
        // Toast.makeText(getApplicationContext(),userId,Toast.LENGTH_SHORT).show();
    }

    public void onShakeImage() {
        Animation shake;
        shake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);


        i1.startAnimation(shake); // starts animation
        i2.startAnimation(shake);
        i3.startAnimation(shake);
        i4.startAnimation(shake);
    }


}
