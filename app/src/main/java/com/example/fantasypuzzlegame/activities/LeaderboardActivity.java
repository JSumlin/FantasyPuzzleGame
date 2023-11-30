package com.example.fantasypuzzlegame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fantasypuzzlegame.R;
import com.example.fantasypuzzlegame.database.DataSource;
import com.example.fantasypuzzlegame.database.Leaderboard;
import com.example.fantasypuzzlegame.database.LeaderboardRanking;
import com.example.fantasypuzzlegame.database.LeaderboardRankingAdapter;

public class LeaderboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
    }

    public void onCastleSelect(View view) {
        Button button = findViewById(view.getId());
        int castleNumber = Integer.parseInt(button.getText().toString().substring(7));
        updateRankingList(castleNumber);
        Intent intent = new Intent(this, LeaderboardDisplayActivity.class);
        startActivity(intent);
    }

    public void onBack(View view){
        finish();
    }

    private void updateRankingList(int levelID){
        DataSource dataSource = new DataSource(this);
        Leaderboard.leaderboardList.clear();

        dataSource.populateLeaderboardList(levelID);
    }
}