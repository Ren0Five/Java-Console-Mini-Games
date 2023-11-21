package com.minigames;

import com.minigames.interfaces.UserInterfaceable;
import com.minigames.rockpaperandscissors.RockPaperAndScissorsUserInterface;
import com.minigames.tictactoe.TicTacToeGame;

import java.util.Scanner;

public class GameSelection implements UserInterfaceable {
    private Scanner scan;
    private GameRegistry gameRegistry;

    public GameSelection(){
        this.scan = new Scanner(System.in);
        this.gameRegistry = new GameRegistry();
        this.gameRegistry.registerGame(new RockPaperAndScissorsUserInterface());
        this.gameRegistry.registerGame(new TicTacToeGame());
    }

    @Override
    public void start() {
        System.out.printf("-----------------------------------------%n");
        System.out.printf("%30s%n","Welcome to Mini games!");


            while (true) {
                drawConsoleUI();
                String input = scan.nextLine();
                if(isValidInput(input)){
                    int x = Integer.parseInt(input);
                    if(x == 0){
                        System.out.println("Thank you for playing Mini games");
                        break;
                    }
                    System.out.println();
                    gameRegistry.getGame(x-1).start();
                }else
                    System.out.println("Invalid Input!");
            }

    }
    public boolean isValidInput(String input){
        if(input == null)
            return false;
        try{
            if(Integer.parseInt(input) > gameRegistry.numberOfGames()) {
                return false;
            }
        }catch (NumberFormatException ex){
            return false;
        }
        return true;
    }


    private void drawConsoleUI(){
        System.out.printf("-----------------------------------------%n");
        for(int x = 0; x < gameRegistry.numberOfGames()+2; x++){
            System.out.print("|");
            for(int j = 0; j<39; j++){
                if(x == 0) {
                    System.out.printf("%-39s", " Select a Game:");
                    break;
                }
                else if(x <= gameRegistry.numberOfGames()){
                    String gameTextSelection = (gameRegistry.getGame(x-1).isFinished()) ?
                                    gameRegistry.getGame(x-1).getGameTitle():
                                    gameRegistry.getGame(x-1).getGameTitle() + "(Coming soon!)";
                    System.out.printf("%-39s"," ["+x+"] "+ gameTextSelection);
                    break;
                }else{
                    System.out.printf("%-39s"," [0] Exit");
                    break;
                }
            }
            System.out.println("|");
        }
        System.out.printf("-----------------------------------------%n");
    }
}
