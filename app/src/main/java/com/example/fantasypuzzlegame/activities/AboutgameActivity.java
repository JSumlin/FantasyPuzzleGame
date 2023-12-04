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
        String lore = "*Game Title*: Fantasy Puzzle Game\n" +
                "\n" +
                "*Description*:\n" +
                "Embark on an enchanting journey in Fantasy Puzzle Game, a fantasy-themed puzzle adventure that captivates the mind and ignites the imagination. Set in a mystical world, this game invites players to explore ancient castles, mysterious lands, and magical realms.\n" +
                "\n" +
                "*Key Features*:\n" +
                "1. *Enthralling Puzzles*: Each level presents unique puzzles that challenge players' problem-solving skills. From simple beginnings to complex arrangements, the puzzles become progressively more challenging, offering a satisfying blend of difficulty and enjoyment.\n" +
                "\n" +
                "2. *Fantasy World Lore*: Dive deep into the lore of Fantasy Puzzle Game, where every castle has a story, and every character brings a piece of the world's rich history. Discover the tales of ancient magic, heroic quests, and forgotten civilizations.\n" +
                "\n" +
                "3. *Magical Castles*: Progress through various castles, each with its distinct theme and puzzles. Unlock new areas by solving puzzles, and unveil hidden secrets and treasures.\n" +
                "\n" +
                "4. *Stunning Visuals and Soundtrack*: Immerse yourself in beautifully crafted environments, accompanied by an enchanting soundtrack that complements the game's magical atmosphere.\n" +
                "\n" +
                "5. *Family-Friendly Adventure*: Designed for all ages, Fantasy Puzzle Game maintains a light and child-friendly tone, making it a perfect game for both young players and the young at heart.\n" +
                "\n" +
                "6. *Offline Play*: Enjoy the game anywhere, anytime, with fully offline gameplay that ensures uninterrupted adventure, even on the go.\n" +
                "\n" +
                "*Closing Thoughts*:\n" +
                "Fantasy Puzzle Game is not just a puzzle game; it's a journey through a fantasy world filled with wonder and excitement. Perfect for puzzle enthusiasts and fantasy lore fans alike, this game promises to provide hours of engaging gameplay for the whole family.";
        loreTextView.setText(lore);
    }
}