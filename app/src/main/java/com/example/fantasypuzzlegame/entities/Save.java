package com.example.fantasypuzzlegame.entities;

public class Save {
    private String name;

    public Save(String name) {
        this.name = name;
    }

    public Save() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
