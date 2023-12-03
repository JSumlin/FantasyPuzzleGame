package com.example.fantasypuzzlegame.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.fantasypuzzlegame.entities.LeaderboardEntry;
import com.example.fantasypuzzlegame.entities.LeaderboardRanking;
import com.example.fantasypuzzlegame.entities.Level;
import com.example.fantasypuzzlegame.entities.LevelCompletion;
import com.example.fantasypuzzlegame.entities.Load;
import com.example.fantasypuzzlegame.entities.Save;

import java.util.ArrayList;
import java.util.Calendar;

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

    public Long insertSave(Save save){
        long id;
        try{
            ContentValues initialValues = new ContentValues();

            initialValues.put("name", save.getName());
            id = database.insert("saves", null, initialValues);
        } catch (Exception e){
            return -1L;
        }
        return id;
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
            initialValues.put("num_of_completions", leaderboardEntry.getNumOfLevelsCompleted());
            didSucceed = database.insert("leaderboard", null, initialValues) > 0;
        } catch (Exception e){
            didSucceed = false;
        }
        return didSucceed;
    }

    public boolean fullSave(){
        boolean didSucceed = true;
        try{
            ContentValues contentValues;
            int integerBoolean;
            int numOfCompletions = 0;
            for (int i = 0; i < SaveState.castleCompletions.length; i++){
                contentValues = new ContentValues();
                contentValues.put("id", SaveState.castleCompletionIds[i]);
                if(SaveState.castleCompletions[i]) {
                    integerBoolean = 1;
                    numOfCompletions++;
                } else integerBoolean = 0;
                contentValues.put("is_completed", integerBoolean);
                contentValues.put("level_id", i+1);
                contentValues.put("save_id", SaveState.saveID);
                didSucceed = didSucceed && database.update("level_completions", contentValues,
                        "id =?", new String[]{String.valueOf(SaveState.castleCompletionIds[i])}) > 0;
            }
            contentValues = new ContentValues();
            contentValues.put("num_of_completions", numOfCompletions);
            didSucceed = didSucceed && database.update("leaderboard", contentValues, "save_id =?",
                    new String[]{String.valueOf(SaveState.saveID)}) > 0;

        } catch (Exception e){
            didSucceed = false;
        }
        return didSucceed;
    }

    public Integer getLevelCompletionId(int saveID, int levelID){
        Integer levelCompletionId = null;
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        boolean successful = false;
        try(Cursor result = sqLiteDatabase.rawQuery("SELECT id FROM level_completions WHERE " +
                        "save_id = " + saveID + " AND level_id = "+levelID+";",
                null)) {
            if(result.getCount() != 0)
            {
                successful = true;
                while (result.moveToNext())
                {
                    levelCompletionId = result.getInt(0);
                }
            }
        }
        dbHelper.close();
        return levelCompletionId;
    }

    public boolean getSave(int saveID) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        boolean successful = false;
        try(Cursor result = sqLiteDatabase.rawQuery("SELECT id, save_id, level_id, is_completed " +
                "FROM level_completions WHERE save_id = " + saveID, null)) {
            if(result.getCount() != 0)
            {
                successful = true;
                SaveState.saveID = saveID;
                while (result.moveToNext())
                {
                    SaveState.castleCompletionIds[result.getInt(2) - 1] = result.getInt(0);
                    SaveState.castleCompletions[result.getInt(2) - 1] = result.getInt(3) == 1;
                }
            }
        }
        return successful;
    }

    public ArrayList<Load> getAllSaves(){
        ArrayList<Load> saves = new ArrayList<Load>();
        try {
            String query = "SELECT  * FROM saves ORDER BY id ASC;";
            Cursor cursor = database.rawQuery(query, null);

            Load newSave;
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                newSave = new Load();
                newSave.setSaveId(cursor.getInt(0));
                newSave.setSaveName(cursor.getString(1));
                saves.add(newSave);
                cursor.moveToNext();
            }
            cursor.close();
        }
        catch (Exception e) {
            saves = new ArrayList<Load>();
        }
        return saves;
    }

    public ArrayList<LeaderboardRanking> getAllRankings(){
        ArrayList<LeaderboardRanking> rankings = new ArrayList<LeaderboardRanking>();
        try {
            String query = "SELECT name, num_of_completions FROM leaderboard INNER JOIN saves ON " +
                    "saves.id = leaderboard.save_id ORDER BY num_of_completions DESC;";
            Cursor cursor = database.rawQuery(query, null);

            LeaderboardRanking newRanking;
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                newRanking = new LeaderboardRanking();
                newRanking.setSaveName(cursor.getString(0));
                newRanking.setNumOfLevelsCompleted(cursor.getInt(1));
                rankings.add(newRanking);
                cursor.moveToNext();
            }
            cursor.close();
        }
        catch (Exception e) {
            rankings = new ArrayList<LeaderboardRanking>();
        }
        return rankings;
    }
}
