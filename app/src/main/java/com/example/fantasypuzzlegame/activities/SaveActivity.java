package com.example.fantasypuzzlegame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

import com.example.fantasypuzzlegame.R;
import com.example.fantasypuzzlegame.database.DataSource;

public class SaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
    }

    public void onSave(View view){
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
            Toast.makeText(SaveActivity.this, "Save successful", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(SaveActivity.this, "Save unsuccessful", Toast.LENGTH_SHORT).show();
        }
    }
}