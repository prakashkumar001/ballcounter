package com.dexeldesigns.ballcounter.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dexeldesigns.ballcounter.R;
import com.dexeldesigns.ballcounter.adapter.PlayerListAdapter;

/**
 * Created by Creative IT Works on 15-Jan-18.
 */

public class ListofPlayers extends AppCompatActivity {
    RecyclerView playerlist1,playerlist2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listofplayers);
      /*  playerlist1=(RecyclerView)findViewById(R.id.playerlist1);
        playerlist2=(RecyclerView)findViewById(R.id.playerlist2);
*/
        PlayerListAdapter adapter = new PlayerListAdapter(ListofPlayers.this);
        LinearLayoutManager ll = new LinearLayoutManager(ListofPlayers.this);
        ll.setOrientation(LinearLayoutManager.VERTICAL);
        playerlist1.setLayoutManager(ll);
        playerlist1.setAdapter(adapter);

    }
}
