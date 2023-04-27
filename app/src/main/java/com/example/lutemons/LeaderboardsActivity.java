package com.example.lutemons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.HashMap;
import java.util.Objects;

public class LeaderboardsActivity extends AppCompatActivity {

    /*
    private Storage storage;
    private String LBText = "";
    private Integer i = 1;
    private TextView leaderBoardTextView;
    */
    private HashMap<Integer, Lutemon> lutemonHashMap = new HashMap<>();
    private ListView listView;
    private LBPageAdapter LBPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_leaderboards);
        LBPageAdapter = new LBPageAdapter(getApplicationContext());
        listView = findViewById(R.id.LBListView);
        listView.setAdapter(LBPageAdapter);


    }

}