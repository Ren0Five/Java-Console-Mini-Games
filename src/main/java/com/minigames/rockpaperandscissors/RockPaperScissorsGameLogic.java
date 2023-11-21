package com.minigames.rockpaperandscissors;


public class RockPaperScissorsGameLogic {

    public RockPaperScissors rps;
    public PointingSystem person, computer;


    public RockPaperScissorsGameLogic(){
         this.rps = null;
         this.person = new PointingSystem(0);
         this.computer = new PointingSystem(0);
    }

    public boolean answerValidation(char answer) {

        if(Character.isUpperCase(answer)){
           answer = Character.toLowerCase(answer);
        }

        if (answer == RockPaperScissors.ROCK.initial) {
            rps = RockPaperScissors.ROCK;
            return true;
        }
        else if(answer == RockPaperScissors.PAPER.initial){
            rps  = RockPaperScissors.PAPER;

            return true;
        }
        else if(answer == RockPaperScissors.SCISSORS.initial){
            rps  = RockPaperScissors.SCISSORS;

            return true;
        }

        return false;
    }
    public void checkAnswers(RockPaperScissors userAnswer, RockPaperScissors computerAnswer){

        switch(computerAnswer) {
            case ROCK:
                if (userAnswer == computerAnswer)
                    System.out.println("Tie!\n");
                else if (userAnswer == RockPaperScissors.PAPER)
                    person.addPoints(); //System.out.println("You Win!\n\n");
                else
                    computer.addPoints(); //System.out.println("Computer Wins you Idiot!\n\n");
                break;
            case PAPER:
                if (userAnswer == computerAnswer)
                    System.out.println("Tie!\n");
                else if (userAnswer == RockPaperScissors.SCISSORS)
                    person.addPoints(); //System.out.println("You Win!\n\n");
                else
                    computer.addPoints(); //System.out.println("Computer Wins you Idiot!\n\n");
                break;
            case SCISSORS:
                if (userAnswer == computerAnswer)
                    System.out.println("Tie!\n");
                else if (userAnswer == RockPaperScissors.ROCK)
                    person.addPoints(); //System.out.println("You Win!\n\n");
                else
                    computer.addPoints(); //System.out.println("Computer Wins you Idiot!\n\n");
                break;
        }
    }


     /*public static void countDown(){
        for(RockPaperScissors game: rps.values())
            System.out.println(game);

    }*/
}
