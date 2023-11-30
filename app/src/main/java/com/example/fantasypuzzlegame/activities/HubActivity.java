package com.example.fantasypuzzlegame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.fantasypuzzlegame.R;

public class HubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);
    }

    public void onCastle1Select(View view){
        Intent intent = new Intent(this, Castle1Activity.class);
        startActivity(intent);
    }

    public void onCastle2Select(View view){
        Intent intent = new Intent(this, Castle2Activity.class);
        startActivity(intent);
    }

    public void onSave(View view){
        Intent intent = new Intent(this, SaveActivity.class);
        startActivity(intent);
    }

    public void onLeaderboard(View view){
        Intent intent = new Intent(this, LeaderboardActivity.class);
        startActivity(intent);
    }
}