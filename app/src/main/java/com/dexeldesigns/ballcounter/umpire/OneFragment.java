package com.dexeldesigns.ballcounter.umpire;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dexeldesigns.ballcounter.R;


public class OneFragment extends Fragment {

    Button four,six;
    public OneFragment() {
        // Required empty public constructor
    }
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.fragment_one, container, false);
        four=(Button)v.findViewById(R.id.fours);
        six=(Button)v.findViewById(R.id.six);

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return v;
    }
 
}