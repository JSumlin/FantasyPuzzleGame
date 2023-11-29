package com.example.fantasypuzzlegame;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DataSource {
    private SQLiteDatabase database;
    private DBHelper dbHelper;

    public DataSource(Context context){
        dbHelper = new DBHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public boolean insertSave(Save save){
        boolean didSucceed;
        try{
            ContentValues initialValues = new ContentValues();

            initialValues.put("name", save.getName());

            didSucceed = database.insert("saves", null, initialValues) > 0;
        } catch (Exception e){
            didSucceed = false;
        }
        return didSucceed;
    }

    public boolean insertLevels(Level level){
        boolean didSucceed;
        try{
            ContentValues initialValues = new ContentValues();

            initialValues.put("name", level.getName());

            didSucceed = database.insert("levels", null, initialValues) > 0;
        } catch (Exception e){
            didSucceed = false;
        }
        return didSucceed;
    }

    public boolean insertLevelCompletion(LevelCompletion levelCompletion){
        boolean didSucceed;
        try{
            ContentValues initialValues = new ContentValues();

            initialValues.put("save_id", levelCompletion.getSaveID());
            initialValues.put("level_id", levelCompletion.getLevelID());
            initialValues.put("is_completed", levelCompletion.getCompleted());

            didSucceed = database.insert("level_completions", null, initialValues) > 0;
        } catch (Exception e){
            didSucceed = false;
        }
        return didSucceed;
    }

    public boolean insertLeaderboardEntry(LeaderboardEntry leaderboardEntry){
        boolean didSucceed;
        try{
            ContentValues initialValues = new ContentValues();

            initialValues.put("save_id", leaderboardEntry.getSaveID());
            initialValues.put("level_id", leaderboardEntry.getLevelID());
            initialValues.put("completion_time", leaderboardEntry.getCompletionTime());

            didSucceed = database.insert("leaderboard", null, initialValues) > 0;
        } catch (Exception e){
            didSucceed = false;
        }
        return didSucceed;
    }
}
