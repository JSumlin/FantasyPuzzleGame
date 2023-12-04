package com.example.fantasypuzzlegame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import com.example.fantasypuzzlegame.R;
import com.example.fantasypuzzlegame.database.SaveState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    private List<Integer> numbers;
    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        gridLayout = findViewById(R.id.gridLayout);
        initializePuzzle();
    }

    private void initializePuzzle() {
        numbers = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            numbers.add(i);
        }
        numbers.add(9); // Adding 9 as the empty cell
        Collections.shuffle(numbers);

        gridLayout.removeAllViews();

        for (int i = 0; i < 9; i++) {
            Button button = new Button(this);
            button.setText(String.valueOf(numbers.get(i)));
            button.setTag(i + 1); // Store the original position as a tag
            button.setOnClickListener(v -> onButtonClick((Button) v));

            // Customize button appearance or layout parameters if needed
            GridLayout.Spec rowSpec = GridLayout.spec(i / 3, 1);
            GridLayout.Spec colSpec = GridLayout.spec(i % 3, 1);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec, colSpec);
            params.width = GridLayout.LayoutParams.WRAP_CONTENT; // Adjust the width as needed
            params.height = GridLayout.LayoutParams.WRAP_CONTENT; // Adjust the height as needed
            button.setLayoutParams(params);

            gridLayout.addView(button);
        }
    }

    private void onButtonClick(Button button) {
        // Swap the clicked button with the empty cell (if adjacent)
        int buttonPosition = (int) button.getTag();
        int emptyPosition = numbers.indexOf(9); // 9 represents the empty cell

        if (isAdjacent(buttonPosition, emptyPosition)) {
            Collections.swap(numbers, buttonPosition - 1, emptyPosition);
            initializePuzzle();
        }
    }

    private boolean isAdjacent(int position1, int position2) {
        // Check if two positions are adjacent (in the same row or column)
        return Math.abs(position1 / 3 - position2 / 3) + Math.abs(position1 % 3 - position2 % 3) == 1;
    }

    public void checkPuzzle(View view) {
        // Check if the puzzle is solved
        if (isPuzzleSolved()) {
            // Puzzle is solved, you can add your own logic here
            SaveState.castleCompletions[0] = true;
            Intent intent = new Intent(this, YouWinActivity.class);
            startActivity(intent);
            // For example, display a message or start a new puzzle
            initializePuzzle();
        }
    }

    private boolean isPuzzleSolved() {
        // Check if the numbers are in ascending order
        for (int i = 0; i < 8; i++) {
            if (numbers.get(i) != i + 1) {
                return false;
            }
        }
        return true;
    }
}