package com.example.fantasypuzzlegame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import com.example.fantasypuzzlegame.R;
import com.example.fantasypuzzlegame.database.SaveState;

import java.util.ArrayList;
import java.util.List;

public class LettersPuzzleActivity extends AppCompatActivity {

    private String targetWord = "MEMO";
    private List<Character> guess;
    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters_puzzle);

        gridLayout = findViewById(R.id.gridLayout);

        initializeGuess();
    }

    private void initializeGuess() {
        guess = new ArrayList<>();
        for (int i = 0; i < targetWord.length(); i++) {
            Button button = createGuessButton(i);
            guess.add('A');
            gridLayout.addView(button);
        }
    }

    private Button createGuessButton(int index) {
        Button button = new Button(this);
        button.setText(String.valueOf('A'));
        button.setOnClickListener(v -> onGuessButtonClick((Button) v));
        return button;
    }

    private void onGuessButtonClick(Button button) {
        // Implement logic to allow user to change individual letters in the guess
        // For simplicity, you can allow cycling through letters (A -> B -> C -> ... -> Z -> A)
        char currentLetter = button.getText().charAt(0);
        char nextLetter = (char) ((currentLetter - 'A' + 1) % 26 + 'A');
        button.setText(String.valueOf(nextLetter));
    }

    public void checkGuess(View view) {
        // Check if the guess is correct
        if (isGuessCorrect()) {
            SaveState.castleCompletions[1] = true;
            Intent intent = new Intent(this, YouWinActivity.class);
            startActivity(intent);
        } else {
            // Incorrect guess logic, provide feedback
            showMessage("Incorrect. Keep trying!");
        }
    }

    private void showMessage(String message) {
        // Display a message, you can use a Toast or any other UI element
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void showFeedback(String feedback) {
        // Display feedback, you can use a TextView or any other UI element
        // For simplicity, we'll just print the feedback to the log
        Log.d("Wordle", feedback);
    }

    private boolean isGuessCorrect() {
        // Check if the current guess is equal to the target word
        StringBuilder currentGuess = new StringBuilder();
        for (Button button : getGuessButtons()) {
            currentGuess.append(button.getText());
        }
        return currentGuess.toString().equals(targetWord);
    }

    private List<Button> getGuessButtons() {
        List<Button> buttons = new ArrayList<>();
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            View child = gridLayout.getChildAt(i);
            if (child instanceof Button) {
                buttons.add((Button) child);
            }
        }
        return buttons;
    }
}