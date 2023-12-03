package com.example.fantasypuzzlegame.entities;

public class LeaderboardRanking {
    private String saveName;
    private Integer numOfLevelsCompleted;

    public LeaderboardRanking() {
    }

    public LeaderboardRanking(String saveName, Integer numOfLevelsCompleted) {
        this.saveName = saveName;
        this.numOfLevelsCompleted = numOfLevelsCompleted;
    }

    public String getSaveName() {
        return saveName;
    }

    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }

    public Integer getNumOfLevelsCompleted() {
        return numOfLevelsCompleted;
    }

    public void setNumOfLevelsCompleted(Integer numOfLevelsCompleted) {
        this.numOfLevelsCompleted = numOfLevelsCompleted;
    }
}
