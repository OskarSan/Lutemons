package com.example.lutemons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import java.util.Objects;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Objects.requireNonNull(getSupportActionBar()).hide();

    }

    public void newGame(View view){
        Storage.getInstance().getLutemonHashMap().clear();
        Storage.getInstance().saveLutemons(this);
        Intent intent =new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void continueGame(View view){
        Storage.getInstance().loadLutemons(this);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void startLeaderboard(View view){
        Intent intent = new Intent(this, LeaderboardsActivity.class);
        startActivity(intent);
    }
}