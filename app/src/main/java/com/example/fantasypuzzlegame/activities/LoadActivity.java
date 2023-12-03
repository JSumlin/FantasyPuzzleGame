package com.example.fantasypuzzlegame.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fantasypuzzlegame.R;
import com.example.fantasypuzzlegame.database.DataSource;
import com.example.fantasypuzzlegame.database.SaveAdapter;
import com.example.fantasypuzzlegame.database.SaveState;
import com.example.fantasypuzzlegame.entities.Load;

import java.util.ArrayList;

public class LoadActivity extends AppCompatActivity {

    RecyclerView loadList;
    SaveAdapter saveAdapter;
    ArrayList<Load> loads;

    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            int saveId = loads.get(position).getSaveId();
            DataSource ds = new DataSource(LoadActivity.this);
            ds.getSave(saveId);
            Intent intent = new Intent(LoadActivity.this, HubActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
    }

    public void onLoad(View view){
        Button button = findViewById(view.getId());
        String[] parts = button.getText().toString().split(" ", 2);
        int saveID = Integer.parseInt(parts[0]);
        DataSource dataSource = new DataSource(this);
        dataSource.getSave(saveID);
        Intent intent = new Intent(this, HubActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();

        DataSource ds = new DataSource(this);
        try {
            ds.open();
            loads = ds.getAllSaves();
            ds.close();
            if (loads.size() > 0) {
                loadList = findViewById(R.id.rvLoads);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
                loadList.setLayoutManager(layoutManager);
                saveAdapter = new SaveAdapter(loads);
                saveAdapter.setOnItemClickListener(onItemClickListener);
                loadList.setAdapter(saveAdapter);
            }
            else {
                Intent intent = new Intent(LoadActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }
        catch (Exception e) {
            Toast.makeText(this, "Error retrieving contacts", Toast.LENGTH_LONG).show();
        }

    }
}