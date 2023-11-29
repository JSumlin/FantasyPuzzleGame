package com.example.fantasypuzzlegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void beginGame(View view) {
        Intent intent = new Intent(this, HubActivity.class);
        startActivity(intent);
    }

    public void loadGame(View view){
        Intent intent = new Intent(this, LoadActivity.class);
        startActivity(intent);
    }

    public void openLeaderboard(View view){
        Intent intent = new Intent(this, LeaderboardActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}