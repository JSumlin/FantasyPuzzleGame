package com.example.fantasypuzzlegame.database;


import java.util.ArrayList;
import java.util.List;

public class SaveState {

    private static final int numberOfCastles = 2;
    public static Integer saveID;
    public static Boolean[] castleCompletions = new Boolean[numberOfCastles];

    public static Integer[] castleCompletionIds = new Integer[castleCompletions.length];
}
