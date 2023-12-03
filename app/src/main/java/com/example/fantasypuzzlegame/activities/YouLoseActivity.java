package com.example.fantasypuzzlegame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fantasypuzzlegame.R;

public class YouLoseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_lose);
    }

    public void onReturnToHub(View view){
        Intent intent = new Intent(this, HubActivity.class);
        startActivity(intent);
    }
}