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
import java.util.stream.Collectors;

/**
 *
 * @author coleogden
 */
public class StateCapitals3 {
    public void run(String fileName) throws FileNotFoundException {
        Map<String,Capital> stateCapitals = new HashMap<>();

        Scanner in = new Scanner(new BufferedReader(new FileReader(fileName)));

        String currentLine = "";
        String[] stateInfo = new String[4];
        int count = 0;
        while(in.hasNextLine()) {
            currentLine = in.nextLine();
            stateInfo = currentLine.split("::");
            Capital newCapitalObj = new Capital(stateInfo[1] /*city name*/ ,Integer.parseInt(stateInfo[2]) /* population*/ ,Double.parseDouble(stateInfo[3]) /* square area */);
            stateCapitals.put(stateInfo[0] /*state*/, newCapitalObj);
            count++;
        }
        System.out.println("There are " + count + " states loaded.");
        
        stateCapitals.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " - " + entry.getValue().toString());
        });
        System.out.println("Please enter the lower limit for population: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("Finding states with population greater than " + num 
                + "\n=====================================================");
        Map<String,Capital> valsThatMeetSearchCriteria = stateCapitals.entrySet().stream().filter(entry -> (entry.getValue().getPopulation() > num)).collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        valsThatMeetSearchCriteria.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " - " + entry.getValue().toString());
        });
        
        System.out.println("Please enter the upper square milage for area: ");
        int upperBound = sc.nextInt();
        System.out.println("Finding states with square milage lower than " + upperBound 
                + "\n================================================");
        Map<String,Capital> statesWithSmallerSquareArea = stateCapitals.entrySet().stream().filter(entry -> (entry.getValue().getSquareMilage() < upperBound)).collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
        statesWithSmallerSquareArea.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " - " + entry.getValue().toString());
        });
        
    }
}
