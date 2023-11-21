package com.minigames;

import com.minigames.interfaces.UserInterfaceable;

public class Game implements UserInterfaceable {
     private String gameTitle;

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    @Override
    public void start() {
        System.out.println("All games must start");
    }

    public boolean isFinished(){
        return false;
    }
}
