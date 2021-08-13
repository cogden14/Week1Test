
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
public class HealthyHearts {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        System.out.println("What is your age?");
        int age = Integer.parseInt(inputReader.nextLine());
        int max = 220 - age; ;
        int minRange = (int)Math.round((max * .5));
        int maxRange = (int)Math.round((max * .85));
        System.out.println("Your maximum heart rate should be " + max + " beats per minute.");
        System.out.println("Your target HR Zone is " + minRange + " - " + maxRange + " beats per minute.");
    }
}
