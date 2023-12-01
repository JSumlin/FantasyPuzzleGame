package com.example.fantasypuzzlegame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fantasypuzzlegame.R;
import com.example.fantasypuzzlegame.database.SaveState;

public class Castle1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_castle1);
    }

    public void onWin(View view){
        SaveState.castleCompletions[0] = true;
        Intent intent = new Intent(this, YouWinActivity.class);
        startActivity(intent);
    }
}