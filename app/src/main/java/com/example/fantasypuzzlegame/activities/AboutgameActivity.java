package com.example.fantasypuzzlegame.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.fantasypuzzlegame.R;

public class AboutgameActivity extends AppCompatActivity {

    private TextView loreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_game);

        loreTextView = findViewById(R.id.loreTextView);

        loadGameLore();
    }

    private void loadGameLore() {
        // Dummy implementation for loading game lore
        String lore = "Detailed lore about the fantasy world...";
        loreTextView.setText(lore);
    }
}