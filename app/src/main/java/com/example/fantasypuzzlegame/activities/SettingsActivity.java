package com.example.fantasypuzzlegame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fantasypuzzlegame.R;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void onSave(View view){
        Intent intent = new Intent(this, SaveActivity.class);
        startActivity(intent);
    }

    public void onQuit(View view){
        Intent intent = new Intent(this, QuitActivity.class);
        startActivity(intent);
    }
}