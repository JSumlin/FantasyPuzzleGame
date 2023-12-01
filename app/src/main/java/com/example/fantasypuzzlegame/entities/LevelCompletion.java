package com.example.fantasypuzzlegame.entities;

public class LevelCompletion {

    private Integer saveID;
    private Integer levelID;
    private Boolean isCompleted;

    public Integer getSaveID() {
        return saveID;
    }

    public LevelCompletion() {
    }

    public LevelCompletion(Integer saveID, Integer levelID, Boolean isCompleted) {
        this.saveID = saveID;
        this.levelID = levelID;
        this.isCompleted = isCompleted;
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

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }
}
