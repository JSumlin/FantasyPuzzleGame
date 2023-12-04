package com.example.fantasypuzzlegame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.fantasypuzzlegame.R;
import com.example.fantasypuzzlegame.database.SaveState;

import java.util.ArrayList;

public class HubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);
//        TextView textView = findViewById(R.id.textView4);
//        textView.setText("Save: " + SaveState.saveID+", "+SaveState.castleCompletions[0]+", "+SaveState.castleCompletions[1]);
    }

    @Override
    public void onResume(){
        super.onResume();
        ArrayList<ImageView> castleFlags = new ArrayList<>();
        castleFlags.add(findViewById(R.id.castle1FlagImage));
        castleFlags.add(findViewById(R.id.castle2FlagImage));
        if(SaveState.castleCompletions[0]) castleFlags.get(0).setVisibility(View.VISIBLE);
        else castleFlags.get(0).setVisibility(View.INVISIBLE);
        if(SaveState.castleCompletions[1]) castleFlags.get(1).setVisibility(View.VISIBLE);
        else castleFlags.get(1).setVisibility(View.INVISIBLE);
    }

    public void onCastle1Select(View view){
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
    }

    public void onCastle2Select(View view){
        Intent intent = new Intent(this, LettersPuzzleActivity.class);
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