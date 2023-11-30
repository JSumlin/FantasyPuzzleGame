package com.example.fantasypuzzlegame.entities;

public class LeaderboardEntry {

    private Integer saveID;
    private Integer levelID;
    private Integer completionTime;

    public LeaderboardEntry() {
    }

    public LeaderboardEntry(Integer saveID, Integer levelID, Integer completionTime) {
        this.saveID = saveID;
        this.levelID = levelID;
        this.completionTime = completionTime;
    }

    public Integer getSaveID() {
        return saveID;
    }

    public void setSaveID(Integer saveID) {
        this.saveID = saveID;
    }

    public Integer getLevelID() {
        return levelID;
    }

    public void setLevelID(Integer levelID) {
        this.levelID = levelID;
    }

    public Integer getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(Integer completionTime) {
        this.completionTime = completionTime;
    }
}
