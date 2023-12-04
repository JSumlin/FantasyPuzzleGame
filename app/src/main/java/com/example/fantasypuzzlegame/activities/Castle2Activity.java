package com.example.fantasypuzzlegame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import com.example.fantasypuzzlegame.R;
import com.example.fantasypuzzlegame.database.SaveState;

import java.util.Locale;

public class Castle2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_castle1);
        timerTextView = findViewById(R.id.timerTextView);
        startTimer();
    }

    public void onWin(View view){
        SaveState.castleCompletions[0] = true;
        Intent intent = new Intent(this, YouWinActivity.class);
        startActivity(intent);
    }


    private TextView timerTextView;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = 60000; // 60 seconds

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                // Code to handle what happens when the timer finishes
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 90;
        int seconds = (int) (timeLeftInMillis / 1000) % 90;
        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        timerTextView.setText(timeFormatted);
    }
}