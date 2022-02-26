package RockPaperScissorsGame;

import java.util.Random;
import java.util.Scanner;

public class RPSGame {  // Rock Paper Scissors Game

    public static String human;
    public static String computer;
    public static Scanner input = new Scanner(System.in);
    public static int HumanScore = 0;
    public static int ComputerScore = 0;
    public static int no_of_chances;
    public static int i = 0;
    public static Random random = new Random();

    public static int getHumanChoice(){
         int choice;
         System.out.println("**** Choose Any One ****");
         System.out.println("\n 1.Rock \n 2.Paper \n 3.Scissors \n");
         choice = input.nextInt();
         switch (choice){
             case 1 :
                 human = "Rock";
                 break;
             case 2:
                 human = "Paper";
                 break;
             case 3:
                 human = "Scissors";
                 break;

             default:
                 getHumanChoice();
                 break;
         }

         return choice;
    }

    public static int getComputerChoice(){

        int choice = random.nextInt(3);

        switch (choice){
            case 0:
                computer = "Rock";
                break;
            case 1:
                computer = "Paper";
                break;
            case 2:
                computer = "Scissors";
                break;
            default:
                System.out.println("Please Choose the Vaid One !!");
                getComputerChoice();
                break;
        }
        return  choice;
    }

    public static String computeWinner(){
        String winner = " ";
        if(human == "Rock" && computer == "Scissors"){
               winner = human;
        }else if(human == "Rock" && computer == "Paper"){
              winner = computer;
        }else if(human == "Rock" && computer == "Rock"){
              winner = " ";
        }else if(human == "Scissors" && computer == "Paper"){
             winner = human;
        }else if(human == "Scissors" && computer == "Scissors"){
            winner = " ";
        }else if(human == "Scissors" && computer == "Rock"){
            winner = computer;
        }else if(human == "Paper" && computer == "Rock"){
            winner = human;
        }else if(human == "Paper" && computer == "Scissors"){
            winner = computer;
        }else if(human == "Paper" && computer == "Paper"){
            winner = " ";
        }else{
            System.out.println("Null");
        }

        return  winner;
    }


    public static void getScoreOfEachPlayers(){
        String winner = computeWinner();
        if(winner == human){
            HumanScore++;
        }else if(winner == computer){
            ComputerScore++;
        }else if(winner == " "){
            ComputerScore++;
            HumanScore++;
        }else{
            System.out.println(" ");
        }
    }


    public static void DisplayResult(){
        String message = " ";
        if(HumanScore > ComputerScore){
            message = "Human Won The RPS GAME !!";
        }else if(ComputerScore > HumanScore){
            message = "Computer Won The RPS Game !!";
        }else if(ComputerScore == HumanScore){
            message = "Draw Game";
        }else{
            message = " ";
        }

        System.out.println(message);
    }

    public static void PlayRPSGame(){
         System.out.println("How many chances u want to play ?? : ");
         no_of_chances = input.nextInt();
         if(no_of_chances == 1){
             System.out.printf("Best of  %d  Chance!! \n",no_of_chances);
         }else {
             System.out.printf("Best of  %d  Chances!! \n", no_of_chances);
         }
         System.out.println("Game Begins.. \n");
         try{
             while(i < no_of_chances){


                 System.out.println("---------------------------------");
                 System.out.printf(" Chance : %d \n",i+1);
                 System.out.println("---------------------------------");

                 int humanChoice = getHumanChoice();
                 int computerChoice = getComputerChoice();


                 System.out.println("");
                 System.out.println("Human is : " + human);
                 System.out.println("Computer is : " + computer);
                 System.out.println("");

                 getScoreOfEachPlayers();

                 System.out.println("");
                 System.out.println("Human Score : "+ HumanScore);
                 System.out.println("Computer Score : " + ComputerScore);
                 System.out.println("");

                 i++;
                 Thread.sleep(1000);
             }
         }catch (Exception e){};

         DisplayResult();
    }

    public static void main(String[] args){
         PlayRPSGame();
    }
}
