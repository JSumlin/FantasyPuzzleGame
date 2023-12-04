package com.example.fantasypuzzlegame.activities;
import java.util.Random;
public class NumberPuzzle {
    private final int[] puzzle;
    private boolean isSolved;
    private Random random;

    public NumberPuzzle() {
        // Initialize puzzle
        puzzle = new int[]{2, 3, 1}; // Example initial state
        isSolved = false;
    }

    public void shuffle() {
        // Logic to shuffle the puzzle
        for (int i = puzzle.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Simple swap
            int temp = puzzle[index];
            puzzle[index] = puzzle[i];
            puzzle[i] = temp;
        }
    }

    public boolean checkSolution() {
        // Check if the puzzle is solved
        for (int i = 0; i < puzzle.length - 1; i++) {
            if (puzzle[i] > puzzle[i + 1]) {
                return false;
            }
        }
        isSolved = true;
        return true;
    }

    public int[] getPuzzle() {
        return puzzle;
    }
    // Getters and setters
}
