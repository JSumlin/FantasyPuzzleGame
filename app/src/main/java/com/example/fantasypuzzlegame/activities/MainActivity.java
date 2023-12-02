package com.example.fantasypuzzlegame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fantasypuzzlegame.R;
import com.example.fantasypuzzlegame.database.DataSource;
import com.example.fantasypuzzlegame.database.SaveState;
import com.example.fantasypuzzlegame.entities.LevelCompletion;

public class MainActivity extends AppCompatActivity {

    public void beginGame(View view) {
        Intent intent = new Intent(this, NewSaveActivity.class);
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