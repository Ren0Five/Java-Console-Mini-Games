package com.minigames;

import java.util.ArrayList;
import java.util.List;

public class GameRegistry {
    private List<Game> games;

    public List<Game> getGames() {
        return games;
    }

    public GameRegistry(){
        this.games = new ArrayList<>();
    }

    public void registerGame(Game game){
        games.add(game);
    }

    public int numberOfGames(){
        return games.size();
    }

    public Game getGame(int index){
        return games.get(index);
    }

}
