package com.dexeldesigns.ballcounter.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dexeldesigns.ballcounter.R;

/**
 * Created by Creative IT Works on 17-Jan-18.
 */

public class Home extends AppCompatActivity {

    Button manageTeams;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        manageTeams=(Button)findViewById(R.id.manageteams);
        manageTeams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
