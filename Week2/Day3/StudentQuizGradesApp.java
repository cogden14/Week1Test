/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;

import static Day3.StudentQuizGrades.userIO;

/**
 *
 * @author coleogden
 */
public class StudentQuizGradesApp {
        public static void main(String[] args) {
        run();
    }
    
    public static void run() {
        StudentQuizGrades studentQuizGrades = new StudentQuizGrades();
        int selection = 0;
        do {
            userIO.print("Student Quiz Scores");
            userIO.print("1) View a list of students in the system");
            userIO.print("2) Add a student to the system");
            userIO.print("3) Remove a student from the system");
            userIO.print("4) View a list of quiz scores for a student");
            userIO.print("5) View the average quiz score for a student");
            userIO.print("6) Get average quiz score of class");
            userIO.print("7) Exit");
            
            selection = userIO.readInt("Enter a number to select operation: ", 1, 7);
            
            if(selection != 7){
                studentQuizGrades.delegateSelection(selection);
            }
        } while (selection != 7);
        
        System.out.println("Thank you! Come again!");
    }
}
