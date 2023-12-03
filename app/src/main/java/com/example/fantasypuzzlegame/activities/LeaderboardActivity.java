package com.example.fantasypuzzlegame.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fantasypuzzlegame.R;
import com.example.fantasypuzzlegame.database.DataSource;
import com.example.fantasypuzzlegame.database.LeaderboardEntryAdapter;
import com.example.fantasypuzzlegame.database.SaveAdapter;
import com.example.fantasypuzzlegame.entities.LeaderboardRanking;
import com.example.fantasypuzzlegame.entities.Load;

import java.util.ArrayList;

public class LeaderboardActivity extends AppCompatActivity {

    RecyclerView rankingList;
    LeaderboardEntryAdapter entryAdapter;
    ArrayList<LeaderboardRanking> rankings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
    }

    @Override
    public void onResume() {
        super.onResume();

        DataSource ds = new DataSource(this);
        try {
            ds.open();
            rankings = ds.getAllRankings();
            ds.close();
            if (rankings.size() > 0) {
                rankingList = findViewById(R.id.rvRankings);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
                rankingList.setLayoutManager(layoutManager);
                entryAdapter = new LeaderboardEntryAdapter(rankings);
                rankingList.setAdapter(entryAdapter);
            }
            else {
                Intent intent = new Intent(LeaderboardActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }
        catch (Exception e) {
            Toast.makeText(this, "Error retrieving rankings", Toast.LENGTH_LONG).show();
        }

    }
}