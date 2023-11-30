package com.example.fantasypuzzlegame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.fantasypuzzlegame.R;
import com.example.fantasypuzzlegame.database.Leaderboard;
import com.example.fantasypuzzlegame.database.LeaderboardRankingAdapter;

public class LeaderboardDisplayActivity extends AppCompatActivity {

    private ListView leaderboardListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard_display);
        //initWidgets();
       // setRankingAdapter();
    }

    private void setRankingAdapter() {
        LeaderboardRankingAdapter adapter = new LeaderboardRankingAdapter(getApplicationContext(), Leaderboard.leaderboardList);
        leaderboardListView.setAdapter(adapter);
    }

//    private void initWidgets() {
//        leaderboardListView = findViewById(R.id.leaderboardListView);
//    }

    public void onBack(View view){
        finish();
    }
}