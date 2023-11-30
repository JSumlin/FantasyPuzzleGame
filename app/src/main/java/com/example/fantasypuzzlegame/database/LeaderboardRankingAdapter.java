package com.example.fantasypuzzlegame.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.fantasypuzzlegame.R;

import java.util.List;

public class LeaderboardRankingAdapter extends ArrayAdapter<LeaderboardRanking> {
    public LeaderboardRankingAdapter(Context context, List<LeaderboardRanking> rankings)
    {
        super(context, 0, rankings);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LeaderboardRanking ranking = getItem(position);
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ranking_cell, parent, false);

        TextView title = convertView.findViewById(R.id.rankingTextView);
        TextView desc = convertView.findViewById(R.id.completionTimeTextView);

        title.setText(ranking.getRank()+". "+ranking.getName());
        desc.setText(ranking.getCompletionTime());

        return convertView;
    }
}
