package com.example.lutemons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class LeaderboardsActivity extends AppCompatActivity {


    private HashMap<Integer, Lutemon> lutemonHashMap = new HashMap<>();
    private ArrayList<Lutemon> lutemonArrayList = new ArrayList<>();
    private ListView listView;
    private LBPageAdapter LBPageAdapter;

    private TextView textView;
    public Button lvlButton, hpButton, winsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lutemonArrayList = Storage.getInstance().makeNewArrayList();

        lvlButton = findViewById(R.id.lvlButton);
        hpButton = findViewById(R.id.hpButton);
        winsButton = findViewById(R.id.winsButton);

        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_leaderboards);
        LBPageAdapter = new LBPageAdapter(getApplicationContext(), lutemonArrayList);
        listView = findViewById(R.id.LBListView);
        listView.setAdapter(LBPageAdapter);


    }

    public void sortByLVL(View view){
        lutemonArrayList = Storage.getInstance().sortArrayListByLvl();
        LBPageAdapter.notifyDataSetChanged();
    }
    public void sortByHP(View view){
        lutemonArrayList = Storage.getInstance().sortArrayListByHP();
        LBPageAdapter.notifyDataSetChanged();
    }
    public void sortByWins(View view){
        lutemonArrayList = Storage.getInstance().sortArrayListByWins();
        LBPageAdapter.notifyDataSetChanged();
    }

}