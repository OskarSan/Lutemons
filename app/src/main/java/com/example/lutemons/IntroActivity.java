package com.example.lutemons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        getSupportActionBar().hide();

    }

    public void newGame(View view){
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void continueGame(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void startLeaderboard(View view){
        Intent intent = new Intent(this, LeaderboardsActivity.class);
        startActivity(intent);
    }
}