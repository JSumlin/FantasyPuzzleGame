package com.example.fantasypuzzlegame.entities;

public class Load {
    private Integer saveId;
    private String saveName;

    public Load() {
    }

    public Load(Integer saveId, String saveName) {
        this.saveId = saveId;
        this.saveName = saveName;
    }

    public Integer getSaveId() {
        return saveId;
    }

    public void setSaveId(Integer saveId) {
        this.saveId = saveId;
    }

    public String getSaveName() {
        return saveName;
    }

    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }
}
