package com.example.fantasypuzzlegame.database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fantasypuzzlegame.R;
import com.example.fantasypuzzlegame.entities.LeaderboardRanking;
import com.example.fantasypuzzlegame.entities.Load;

import java.util.ArrayList;

public class LeaderboardEntryAdapter extends RecyclerView.Adapter{

    private ArrayList<LeaderboardRanking> leaderboardEntryData;

    public class LeaderboardViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewSave;
        public TextView completionsView;
        public LeaderboardViewHolder(@NonNull View itemView){
            super(itemView);
            textViewSave = itemView.findViewById(R.id.saveName);
            completionsView = itemView.findViewById(R.id.levelCompletionsTextView);
        }

        public TextView getSaveTextView(){
            return textViewSave;
        }
        public TextView getCompletionsView(){
            return completionsView;
        }
    }

    public LeaderboardEntryAdapter(ArrayList<LeaderboardRanking> arrayList){
        leaderboardEntryData = arrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboard_item, parent, false);
        return new LeaderboardEntryAdapter.LeaderboardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position){
        LeaderboardEntryAdapter.LeaderboardViewHolder lbvh =
                (LeaderboardEntryAdapter.LeaderboardViewHolder) holder;
        lbvh.getSaveTextView().setText(position+1 + ". "+leaderboardEntryData.get(position).getSaveName());
        lbvh.getCompletionsView().setText("Castles Conquered: " + leaderboardEntryData.get(position).getNumOfLevelsCompleted());
    }

    @Override
    public int getItemCount(){
        return leaderboardEntryData.size();
    }
}
