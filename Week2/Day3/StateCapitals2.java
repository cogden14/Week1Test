/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author coleogden
 */
public class StateCapitals2 {
    public static void main (String [] args) throws FileNotFoundException {
        Map<String,String> stateCapitals = new HashMap<>();
        Scanner in = new Scanner(new BufferedReader(new FileReader("/Users/coleogden/NetBeansProjects/mavenproject1/src/main/java/Day3/StateCapitals.txt")));

        String currentLine = "";
        String[] place = new String[2];
        int count = 0;
        while(in.hasNextLine()) {
            currentLine = in.nextLine();
            place = currentLine.split("::");
            stateCapitals.put(place[0], place[1]);
            count++;
        }
        
        System.out.println("There are " + count + " states loaded!");

        System.out.println("STATES:\n=======");
        for(String state : stateCapitals.keySet()) {
            System.out.println(state);
        }
        
        System.out.println("\nCAPITALS:\n=========");
        for(String capitalCity : stateCapitals.values()) {
            System.out.println(capitalCity);
        }
        
        System.out.println("\nSTATE/CAPITAL PAIRS:\n====================");
        for(String state : stateCapitals.keySet()) {
            System.out.println(state + " - " + stateCapitals.get(state));
        }
        System.out.println("How many states would you like to guess?");
        Scanner sc = new Scanner(System.in);
        int numToGuess = Integer.parseInt(sc.nextLine());
        int numRight = 0;
        int numWrong = 0;
        //Begin guessing game
        for (int i = 0; i < numToGuess; i++) {
            int rand = (int) (Math.random() * stateCapitals.size()) + 1;
            int index = 0;
            Map.Entry<String, String> entryToGuess = null;
            for (Map.Entry<String, String> entry : stateCapitals.entrySet()) {
                if (index == rand) {
                    entryToGuess = entry;
                    break;
                }
                index++;
            }

            if (entryToGuess != null) {
                System.out.println("Guess the capital of " + entryToGuess.getKey() + ":");
                String guess = sc.nextLine();
                if (guess.equalsIgnoreCase(entryToGuess.getValue())) {
                    System.out.println("Correct! Congrations. You've won!");
                    numRight++;
                } else {
                    System.out.println("Sorry, the correct answer is: " + entryToGuess.getValue());
                    numWrong++;
                }
                // Remove value from map since only running once, avoids duplicate guess
                stateCapitals.remove(entryToGuess.getKey());
            } else {
                System.out.println("Error loading states.");
            }
        }
        System.out.println("Total num right: " + numRight);
        System.out.println("Total num wrong: " + numWrong);
        System.out.println("Total score: " + (numRight - numWrong));

    }
}
