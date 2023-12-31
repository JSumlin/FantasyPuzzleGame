package com.example.fantasypuzzlegame.entities;

public class LeaderboardEntry {

    private Integer saveID;
    private Integer numOfLevelsCompleted;

    public LeaderboardEntry() {
    }

    public LeaderboardEntry(Integer saveID, Integer numOfLevelsCompleted) {
        this.saveID = saveID;
        this.numOfLevelsCompleted = numOfLevelsCompleted;
    }

    public Integer getSaveID() {
        return saveID;
    }

    public void setSaveID(Integer saveID) {
        this.saveID = saveID;
    }

    public Integer getNumOfLevelsCompleted() {
        return numOfLevelsCompleted;
    }

    public void setNumOfLevelsCompleted(Integer numOfLevelsCompleted) {
        this.numOfLevelsCompleted = numOfLevelsCompleted;
    }
}
