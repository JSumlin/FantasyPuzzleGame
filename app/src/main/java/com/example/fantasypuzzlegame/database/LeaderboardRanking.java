package com.example.fantasypuzzlegame.database;

public class LeaderboardRanking {
    private Integer rank;
    private String name;
    private Integer completionTime;

    public LeaderboardRanking() {
    }

    public LeaderboardRanking(Integer rank, String name, Integer completionTime) {
        this.rank = rank;
        this.name = name;
        this.completionTime = completionTime;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(Integer completionTime) {
        this.completionTime = completionTime;
    }


}
