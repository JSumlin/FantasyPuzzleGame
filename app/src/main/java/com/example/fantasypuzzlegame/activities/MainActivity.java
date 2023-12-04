package com.example.fantasypuzzlegame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fantasypuzzlegame.R;
import com.example.fantasypuzzlegame.database.DBHelper;
import com.example.fantasypuzzlegame.database.DataSource;
import com.example.fantasypuzzlegame.database.SaveState;
import com.example.fantasypuzzlegame.entities.LevelCompletion;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button playMusicButton;

    public void beginGame(View view) {
        Intent intent = new Intent(this, NewSaveActivity.class);
        startActivity(intent);
    }

    public void loadGame(View view){
        Intent intent = new Intent(this, LoadActivity.class);
        startActivity(intent);
    }

    public void openLeaderboard(View view){
        Intent intent = new Intent(this, LeaderboardActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize the media player
        mediaPlayer = MediaPlayer.create(this, R.raw.background_music);
        mediaPlayer.setLooping(true);

        // Initialize the play music button and set its click listener
        playMusicButton = findViewById(R.id.playMusicButton);
        playMusicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Play music button clicked");
                if (!mediaPlayer.isPlaying()) {
                    Log.d("MainActivity", "Media player is not null");
                    mediaPlayer.start(); // Start the music
                    Log.d("MainActivity", "Media player starting");
                }
            }
        });
    }

    // Method to be called when the 'About the Game' button is clicked
    public void showAboutGame(View view) {
        Intent intent = new Intent(this, AboutgameActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            if (isFinishing()) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }
}