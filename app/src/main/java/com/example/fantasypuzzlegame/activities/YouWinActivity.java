package com.example.fantasypuzzlegame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fantasypuzzlegame.R;
import com.example.fantasypuzzlegame.database.DataSource;
import com.example.fantasypuzzlegame.database.SaveState;

public class YouWinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_win);
        boolean wasSuccessful;
        DataSource dataSource = new DataSource(this);
        try{
            dataSource.open();
            wasSuccessful = dataSource.fullSave();
            dataSource.close();
        } catch (Exception e){
            wasSuccessful = false;
        }

        if(wasSuccessful){
            Toast.makeText(YouWinActivity.this, "Save successful", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(YouWinActivity.this, "Save unsuccessful", Toast.LENGTH_SHORT).show();
        }
    }

    public void onReturnToHub(View view){
        Intent intent = new Intent(this, HubActivity.class);
        startActivity(intent);
    }
}