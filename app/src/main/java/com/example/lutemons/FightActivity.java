package com.example.lutemons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lutemons.fragments.FightLutemonFragment;

import java.util.ArrayList;

public class FightActivity extends AppCompatActivity {
    protected static ArrayList<String> fightStory;
    private RecyclerView recyclerView;
    private View view;

    protected ArrayList<String> story = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight);

        recyclerView = findViewById(R.id.rvFightStory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new FightingListAdapter(this    , fightStory));

    }

    public static void fetchStory(ArrayList<String> story){
        fightStory = story;
    }


}