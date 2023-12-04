package com.example.fantasypuzzlegame.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import com.example.fantasypuzzlegame.R;
import android.graphics.Bitmap;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FatherActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "PuzzleGamePrefs";
    private static final String KEY_LEVEL = "level";
    private TextView puzzleTextView;
    private int currentLevel;
    private GridView puzzleGrid;
    private PuzzleAdapter puzzleAdapter;
    private int blankPos;

    @Override
    // ... (other parts of your FatherActivity)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_father);

        //Bitmap fullImage = R.raw.castle; // Load your full image here
        InputStream inputStream = getResources().openRawResource(R.raw.castle);
        Bitmap fullImage = BitmapFactory.decodeStream(inputStream);

        List<Bitmap> puzzlePieces = splitImage(fullImage, 4, 4); // Split the image into a 4x4 grid of pieces

        puzzleGrid = findViewById(R.id.puzzleGrid);
        PuzzleAdapter puzzleAdapter = new PuzzleAdapter(this, puzzlePieces);
        puzzleGrid.setAdapter(puzzleAdapter);

        Button solveButton = findViewById(R.id.solvePuzzleButton);
        solveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.shuffle(puzzlePieces); // Shuffle the pieces
                puzzleAdapter.notifyDataSetChanged(); // Notify the adapter to update the grid
            }
        });
    }

    // Method to split the image into pieces
    private List<Bitmap> splitImage(Bitmap image, int rows, int cols) {
        List<Bitmap> pieces = new ArrayList<>(rows * cols);

        int pieceWidth = image.getWidth() / cols;
        int pieceHeight = image.getHeight() / rows;

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                int xCoord = x * pieceWidth;
                int yCoord = y * pieceHeight;
                pieces.add(Bitmap.createBitmap(image, xCoord, yCoord, pieceWidth, pieceHeight));
            }
        }
        return pieces;
    }

//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_father);
//
//        puzzleTextView = findViewById(R.id.puzzleTextView);
//
//        Integer[] puzzlePieces = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0}; // Assuming 0 is the empty space
//
//        GridView puzzleGrid = (GridView) findViewById(R.id.puzzleGrid);
//        puzzleAdapter = new PuzzleAdapter(this, puzzlePieces);
//        puzzleGrid.setAdapter(puzzleAdapter);
//
//        // Load current level from SharedPreferences
//        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
//        currentLevel = settings.getInt(KEY_LEVEL, 1);  // Default to level 1
//
//        loadPuzzle(currentLevel);
//
//        // Rest of your code
//
//    }

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

    // Utility method to split the image
    // ... (other parts of your FatherActivity)
}