package com.minigames.rockpaperandscissors;

public class PointingSystem {

    private int points;
    private int limit;
    private StringBuilder sb;


    public PointingSystem(int points){
        this.points = points;
        this.limit = 5;
        this.sb = new StringBuilder("");
    }

    public int getPoints() {
        return this.points;
    }

    public int getLimit() {
        return limit;
    }

    public StringBuilder getSb() {
        return sb;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addPoints(){
        this.points++;
        sb.append('|');
    }


}
