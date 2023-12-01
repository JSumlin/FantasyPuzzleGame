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

    public boolean fullSave(){
        boolean didSucceed = true;
        try{


            ContentValues contentValues;
            int integerBoolean;
            for (int i = 0; i < SaveState.castleCompletions.length; i++){
                contentValues = new ContentValues();
                contentValues.put("id", SaveState.castleCompletionIds[i]);
                if(SaveState.castleCompletions[i]) integerBoolean = 1;
                else integerBoolean = 0;
                contentValues.put("is_completed", integerBoolean);
                contentValues.put("level_id", i+1);
                contentValues.put("save_id", SaveState.saveID);
                didSucceed = didSucceed && database.update("level_completions", contentValues,
                        "id =?", new String[]{String.valueOf(SaveState.castleCompletionIds[i])}) > 0;
            }


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
                    SaveState.castleCompletionIds[result.getInt(0) - 1] = result.getInt(0);
                    switch (result.getInt(2)){
                        case 1:
                            SaveState.castleCompletions[0] = result.getInt(3) == 1;
                            break;
                        case 2:
                            SaveState.castleCompletions[1] = result.getInt(3) == 1;
                            break;
                    }
                }
            }
        }
        return successful;
    }
}
