package com.example.fantasypuzzlegame.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.fantasypuzzlegame.R;

public class FatherActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "PuzzleGamePrefs";
    private static final String KEY_LEVEL = "level";
    private TextView puzzleTextView;
    private int currentLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_father);

        puzzleTextView = findViewById(R.id.puzzleTextView);

        // Load current level from SharedPreferences
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        currentLevel = settings.getInt(KEY_LEVEL, 1);  // Default to level 1

        loadPuzzle(currentLevel);
    }

    private void loadPuzzle(int level) {
        // Dummy implementation for loading a puzzle based on the level
        String puzzle = "Puzzle for level " + level;
        puzzleTextView.setText(puzzle);
    }

    public void solvePuzzle(View view) {
        // Logic for solving the puzzle (to be implemented)
        // For now, just increase the level
        increaseLevel();
        loadPuzzle(currentLevel);
    }

    private void increaseLevel() {
        currentLevel++;
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(KEY_LEVEL, currentLevel);
        editor.apply();
    }
}