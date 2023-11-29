package com.example.fantasypuzzlegame.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "puzzlesaves.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_SAVES_TABLE = "create table saves (id integer primary key " +
            "autoincrement, name text);";
    private static final String CREATE_LEVELS_TABLE = "create table levels (id integer primary key " +
            "autoincrement, name text);";

    private static final String CREATE_LEVEL_COMPLETIONS_TABLE = "create table level_completions (id integer primary key " +
            "autoincrement, save_id integer, level_id integer, is_completed integer default 0," +
            " foreign key(save_id) references saves(id), foreign key(level_id) references levels(id));";

    private static final String CREATE_LEADERBOARD_TABLE = "create table leaderboard (id integer primary key " +
            "autoincrement, save_id integer, level_id integer, completion_time integer," +
            " foreign key(save_id) references saves(id), foreign key(level_id) references levels(id));";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_SAVES_TABLE);
        db.execSQL(CREATE_LEVELS_TABLE);
        db.execSQL(CREATE_LEVEL_COMPLETIONS_TABLE);
        db.execSQL(CREATE_LEADERBOARD_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS level_completions");
        db.execSQL("DROP TABLE IF EXISTS saves");
        db.execSQL("DROP TABLE IF EXISTS levels");
        db.execSQL("DROP TABLE IF EXISTS leaderboard");
        this.onCreate(db);
    }
}
