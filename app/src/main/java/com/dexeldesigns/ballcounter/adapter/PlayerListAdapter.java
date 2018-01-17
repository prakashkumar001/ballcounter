package com.dexeldesigns.ballcounter.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dexeldesigns.ballcounter.R;
import com.dexeldesigns.ballcounter.common.GlobalClass;

/**
 * Created by Creative IT Works on 17-Jan-18.
 */

public class PlayerListAdapter extends  RecyclerView.Adapter<PlayerListAdapter.MyViewHolder>  {

        GlobalClass global;
        Activity context;




public PlayerListAdapter(Activity context) {

        
        this.context = context;
        global = new GlobalClass();
        //global.selectedProduct=new ArrayList<>();


        }

@Override
public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View  v = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.player_item, parent, false);
        MyViewHolder  vh = new MyViewHolder(v);

        return vh;

        }



@Override
public void onBindViewHolder(MyViewHolder holder, final int position) {









        }

@Override
public int getItemCount() {
        return 11;
        }


@Override
public int getItemViewType(int position) {
        int viewType = 1; //Default is 1
        //if (position == 0) viewType = 0; //if zero, it will be a header view
        return viewType;
        }

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView playerName;

    public MyViewHolder(View view) {
        super(view);




    }


}




}
