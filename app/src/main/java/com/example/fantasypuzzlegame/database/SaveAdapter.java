package com.example.fantasypuzzlegame.database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fantasypuzzlegame.R;
import com.example.fantasypuzzlegame.entities.Load;

import java.util.ArrayList;

public class SaveAdapter extends RecyclerView.Adapter {
    private ArrayList<Load> saveData;
    private View.OnClickListener mOnItemClickListener;

    public class SaveViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewSave;
        public SaveViewHolder(@NonNull View itemView){
            super(itemView);
            textViewSave = itemView.findViewById(R.id.saveInfo);
            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
        }

        public TextView getSaveTextView(){
            return textViewSave;
        }
    }

    public SaveAdapter(ArrayList<Load> arrayList){
        saveData = arrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new SaveViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position){
        SaveViewHolder svh = (SaveViewHolder) holder;
        svh.getSaveTextView().setText(saveData.get(position).getSaveName());
    }

    @Override
    public int getItemCount(){
        return saveData.size();
    }

    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }
}
