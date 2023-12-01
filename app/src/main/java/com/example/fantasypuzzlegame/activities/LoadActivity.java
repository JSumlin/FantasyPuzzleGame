package com.example.fantasypuzzlegame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fantasypuzzlegame.R;
import com.example.fantasypuzzlegame.database.DataSource;

public class LoadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
    }

    public void onLoad(View view){
        Button button = findViewById(view.getId());
        String[] parts = button.getText().toString().split(" ", 2);
        int saveID = Integer.parseInt(parts[0]);
        DataSource dataSource = new DataSource(this);
        dataSource.getSave(saveID);
        Intent intent = new Intent(this, HubActivity.class);
        startActivity(intent);
    }
}