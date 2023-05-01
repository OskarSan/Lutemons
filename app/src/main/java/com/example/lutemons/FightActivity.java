package com.example.lutemons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lutemons.fragments.FightLutemonFragment;

import java.util.ArrayList;
import java.util.Objects;

public class FightActivity extends AppCompatActivity {
    protected static ArrayList<String> fightStory;
    private RecyclerView recyclerView;
    private View view;

    protected ArrayList<String> story = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Taisteluloki");
        LinearLayoutManager LM = new LinearLayoutManager(this);
        FightingListAdapter FLA = new FightingListAdapter(this    , fightStory);

        recyclerView = findViewById(R.id.rvFightStory);
        recyclerView.setLayoutManager(LM);
        recyclerView.setAdapter(FLA);


    }

    public static void fetchStory(ArrayList<String> story){
        fightStory = story;
    }




}
