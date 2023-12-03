package com.example.fantasypuzzlegame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fantasypuzzlegame.R;
import com.example.fantasypuzzlegame.database.DataSource;
import com.example.fantasypuzzlegame.database.SaveState;
import com.example.fantasypuzzlegame.entities.LeaderboardEntry;
import com.example.fantasypuzzlegame.entities.LevelCompletion;
import com.example.fantasypuzzlegame.entities.Save;

public class NewSaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_save);
    }

    public void onSave(View view){
        EditText textInput = findViewById(R.id.saveNameTextInput);
        String saveName = textInput.getText().toString();
        Save save = new Save(saveName);
        boolean wasSuccessful;
        DataSource dataSource = new DataSource(this);
        Long saveId = -1L;
        try{
            dataSource.open();
            saveId = dataSource.insertSave(save);
            wasSuccessful = saveId > 0;
            for(int i = 1; i<= SaveState.castleCompletions.length; i++){
                dataSource.insertLevelCompletion(new LevelCompletion(saveId.intValue(), i, false));
            }
            dataSource.insertLeaderboardEntry(new LeaderboardEntry(saveId.intValue(), 0));
            dataSource.close();
        } catch (Exception e){
            wasSuccessful = false;
        }

        if(wasSuccessful){
            dataSource.getSave(saveId.intValue());
            Intent intent = new Intent(this, HubActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(NewSaveActivity.this, "Save unsuccessful", Toast.LENGTH_SHORT).show();
        }
    }
}