package com.dexeldesigns.ballcounter.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dexeldesigns.ballcounter.R;
import com.dexeldesigns.ballcounter.adapter.PlayerListAdapter;

/**
 * Created by Creative IT Works on 17-Jan-18.
 */

public class ManageTeams extends AppCompatActivity {
    RecyclerView playerlist;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listofplayers);
        playerlist=(RecyclerView)findViewById(R.id.playerlist);

        PlayerListAdapter adapter = new PlayerListAdapter(ManageTeams.this);
        LinearLayoutManager ll = new LinearLayoutManager(ManageTeams.this);
        ll.setOrientation(LinearLayoutManager.VERTICAL);
        playerlist.setLayoutManager(ll);
        playerlist.setAdapter(adapter);

    }
}
