package com.example.fantasypuzzlegame.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.fantasypuzzlegame.entities.LeaderboardEntry;
import com.example.fantasypuzzlegame.entities.Level;
import com.example.fantasypuzzlegame.entities.LevelCompletion;
import com.example.fantasypuzzlegame.entities.Save;

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

    public boolean insertLevel(Level level){
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

    public void populateLeaderboardList(int levelID) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        int rank = 0;

        try(Cursor result = sqLiteDatabase.rawQuery("SELECT name, completion_time FROM saves " +
                "INNER JOIN leaderboard ON saves.id = leaderboard.save_id WHERE leaderboard.level_id " +
                "= "+levelID+" ORDER BY completion_time ASC;", null)) {
            if(result.getCount() != 0)
            {
                while (result.moveToNext())
                {
                    rank++;
                    String name = result.getString(0);
                    Integer completionTime = result.getInt(1);
                    LeaderboardRanking ranking = new LeaderboardRanking(rank, name, completionTime);
                    Leaderboard.leaderboardList.add(ranking);
                }
            }
        }
    }
}
