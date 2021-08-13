
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author coleogden
 */
public class RockPaperScissors {
    private static int numTies = 0;
    private static int numUserWins = 0;
    private static int numComputerWins = 0;
    
    public static void main(String [] args) {
        System.out.println("Rock Paper Scissors Showdown");
        System.out.println("============================");
        Scanner sc = new Scanner (System.in);
        Random num = new Random();
        boolean continuePlaying = true;
        do {
            System.out.println("How many rounds would you like to play? (1-10)");
            String selectionNumRounds = sc.nextLine();
            int numRounds;
            try {
                numRounds = Integer.parseInt(selectionNumRounds);
            } catch(NumberFormatException ex) {
                System.out.println("You did not enter a valid number. Good bye.");
                break;
            }
            if(numRounds < 1 || numRounds > 10) {
                System.out.println("You did not enter a valid number. Good bye.");
                break;
            }
            
            for (int i = 0; i < numRounds; i++) {
                System.out.println("Make your selection (1-Rock, 2-Paper, 3-Scissors):");
                int userSelection;
                try {
                    userSelection = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException ex) {
                    System.out.println("You did not enter a valid number. Good bye.");
                    break;
                }
                if(userSelection!=1 && userSelection!=2 && userSelection!=3) {
                    System.out.println("You did not enter a valid selection. Good bye.");
                    break;
                }
                int computerSelection = num.nextInt(3) + 1;
                
                int gameResult = getResult(userSelection, computerSelection);
                String choiceStringUser = getNameOfMove(userSelection);
                String choiceStringComputer = getNameOfMove(computerSelection);
                System.out.println("User chooses " + choiceStringUser + ", computer chooses " + choiceStringComputer + ". " + getNameOfResult(gameResult));
            }
            
            System.out.println("Number of ties: " + numTies);
            System.out.println("Number of wins by the user: " + numUserWins);
            System.out.println("Number of wins by the computer: " + numComputerWins);
            
            if(numUserWins > numComputerWins) {
                System.out.println("User is the champion. Congratulations!");
            } else if (numComputerWins > numUserWins) {
                System.out.println("Computer is the champion. Better luck next time!");
            } else {
                System.out.println("Tie game.");
            }
            System.out.println("Would you like to play again? (Y/N)");
            String choice = sc.nextLine();
            
            // Anything but Yes, end game
            if(!choice.equals("Y") && !choice.equals("y")) {
                System.out.println("Thanks for playing!");
                continuePlaying = false;
            }
            
        } while(continuePlaying);
    }
    
    //Returns 1 if user wins, returns 2 if computer wins, returns 3 if tie game
    public static int getResult(int userSelection, int computerSelection) {
        if (userSelection == 1 && computerSelection == 2) {
            // user chooses rock, computer chooses paper, computer wins
            numComputerWins++;
            return 2;
        } else if (userSelection == 1 && computerSelection == 3) {
            // user chooses rock, computer chooses scissors, user wins
            numUserWins++;
            return 1;
        } else if (userSelection == 2 && computerSelection == 1) {
            // user chooses paper, computer chooses rock, user wins
            numUserWins++;
            return 1;
        } else if (userSelection == 2 && computerSelection == 3) {
            // user chooses paper, computer chooses scissors, computer wins
            numComputerWins++;
            return 2;
        } else if (userSelection == 3 && computerSelection == 1) {
            // user chooses scissors, computer chooses rock, computer wins
            numComputerWins++;
            return 2;
        } else if (userSelection == 3 && computerSelection == 2) {
            // user chooses scissors, computer chooses paper, user wins
            numUserWins++;
            return 1;
        } else {
            //tie game, return 3
            numTies++;
            return 3;
        }
    }
    
    public static String getNameOfMove(int move) {
        if(move==1) {
            return "rock";
        }
        else if(move==2) {
            return "paper";
        } else {
            return "scissors";
        }
    }
    
    //returns user if 1, computer if 2, tie game if 3
    public static String getNameOfResult(int result) {
        if(result==1) {
            return "User wins.";
        }
        else if(result==2) {
            return "Computer wins.";
        } else {
            return "Tie game.";
        }
    }
}
