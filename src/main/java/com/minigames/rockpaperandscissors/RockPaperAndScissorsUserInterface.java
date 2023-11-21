package com.minigames.rockpaperandscissors;

/*
* Rock Paper and Scissor Console Based application
* Author: Ren Ramos
* */

import com.minigames.Game;

import java.util.*;

public class RockPaperAndScissorsUserInterface extends Game {

    private static final String gameName = "Rock Paper and Scissors";
    private List<RockPaperScissors>choices;
    private RockPaperScissors rps;
    private RockPaperScissorsGameLogic rpsGameLogic;
    private Random rand;
    private Scanner scan;
    public char answer;


   public RockPaperAndScissorsUserInterface(){
       super.setGameTitle(gameName);
       this.scan = new Scanner(System.in);
       this.rand = new Random();
       this.rpsGameLogic = new RockPaperScissorsGameLogic();
       this.choices = Arrays.asList(rps.values());
   }

   @Override
    public void start(){

        System.out.println("Welcome to Rock, Paper, Scissors \nYou versus Computer!");
        System.out.println("'R' for Rock \n'P' for Paper \n'S' for Scissors");
        System.out.println("Points upto 5!");

        try{
            while(true){
                System.out.println("You: " + rpsGameLogic.person.getSb());
                System.out.println("Computer: " + rpsGameLogic.computer.getSb());
                System.out.print("Enter your answer or just Enter nothing to exit: ");
                answer = scan.nextLine().charAt(0);

                this.processAnswer(answer);

            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("\nThank you for Playing with Computer, Bye!");
        }
    }

    public void processAnswer(char answer) throws Exception{
        if(rpsGameLogic.answerValidation(answer)) {
            int computer = rand.nextInt(choices.size());
            System.out.println("Your answer is " + rpsGameLogic.rps);
            System.out.println("Computer's answer is " + choices.get(computer));

            rpsGameLogic.checkAnswers(rpsGameLogic.rps, choices.get(computer));

            if(rpsGameLogic.person.getPoints() == rpsGameLogic.person.getLimit()){
                throw new Exception("You Win!\n\n");
            } else if(rpsGameLogic.computer.getPoints() == rpsGameLogic.computer.getLimit()){
                throw new Exception("Computer Wins you Idiot!\n\n");
            }
        }
        else{
            System.out.println("Invalid Input, Try Again! \n\n");
        }
    }

//    @Override
//    public String getGameTitle(){
//        return gameName;
//    }

    @Override
    public boolean isFinished(){
       return true;
    }

}
