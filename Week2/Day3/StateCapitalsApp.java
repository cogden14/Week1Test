/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;

import java.io.FileNotFoundException;

/**
 *
 * @author coleogden
 */
public class StateCapitalsApp {
    public static void main(String[] args) {
        StateCapitals3 app = new StateCapitals3();
        try {
            app.run("/Users/coleogden/NetBeansProjects/mavenproject1/src/main/java/Day3/MoreStateCapitals.txt");
        } catch (FileNotFoundException fe) {
            System.out.println("Error loading file. Please check file source.");
        }
                
    }
}
