/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author coleogden
 */
public class StudentQuizGrades {
    Map<String,ArrayList<Integer>> studentQuizGrades = new HashMap<>();
    static UserIO userIO = new UserIOImpl();
    
    public void delegateSelection(int selection) {
        switch(selection) {
            case 1 -> printStudents();
            case 2 -> addStudent();
            case 3 -> removeStudent(userIO.readString("Enter the student's name to remove: "));
            case 4 -> userIO.printQuizScores(getQuizScores(userIO.readString("Enter the student's name to get quiz scores: ")));
            case 5 -> userIO.print(String.valueOf(getAvgQuizScore(userIO.readString("Enter the student's name to get average quiz score: "))));
            case 6 -> userIO.print(String.valueOf(getClassAvgScore()));
            case 7 -> userIO.printStudentNames(getStudentsWithHighestScore());
            case 8 -> userIO.printStudentNames(getStudentsWithLowestScore());
        }
    }
    
    public void printStudents() {
        studentQuizGrades.keySet().forEach(student -> {
            userIO.print(student);
        });
    }
    
    public void addStudent() {
        String studentName = userIO.readString("Enter the name of the student: ");
        int grade = 0;
        ArrayList<Integer> grades = new ArrayList<>();
        while (true) {
            grade = userIO.readInt("Enter a value of the grade(Enter -1 to exit):");
            if(grade == -1) {
                break;
            }
            grades.add(grade);
        }
        studentQuizGrades.put(studentName, grades);
    }
    
    public void removeStudent(String name) {
        studentQuizGrades.remove(name);
    }
    
    public ArrayList<Integer> getQuizScores(String name) {
        return studentQuizGrades.get(name);
    }
    
    public int getAvgQuizScore(String name) {
        int sum = 0;
        sum = studentQuizGrades.get(name).stream().map(grade -> grade).reduce(sum, Integer::sum);
        return sum/studentQuizGrades.get(name).size();
    }
    
    public int getClassAvgScore() {
        int gradeSum = 0;
        int totalNumOfQuizzes = 0;
        for(ArrayList<Integer> grades : studentQuizGrades.values()) {
            gradeSum = grades.stream().map(grade -> grade).reduce(gradeSum, Integer::sum);
            totalNumOfQuizzes+=grades.size();
        }
        
        return gradeSum/totalNumOfQuizzes;
    }
    
    public ArrayList<String> getStudentsWithHighestScore() {
        int highestAverage = 0;
        ArrayList<String> studentsWithHighestGrade = new ArrayList<>();
        Iterator it = studentQuizGrades.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            int avg = getAvgQuizScore(String.valueOf(pair.getKey()));
            if(avg > highestAverage) {
                // student has higher grade than previously tracked
                studentsWithHighestGrade.clear();
                highestAverage = avg;
            }
            if (avg == highestAverage) {
                studentsWithHighestGrade.add(String.valueOf(pair.getKey()));
            }
        }
        userIO.print("Highest grade: " + highestAverage);
        return studentsWithHighestGrade;
    }
    
    public ArrayList<String> getStudentsWithLowestScore() {
        int lowestAverage = 100;
        ArrayList<String> studentsWithLowestGrade = new ArrayList<>();
        Iterator it = studentQuizGrades.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            int avg = getAvgQuizScore(String.valueOf(pair.getKey()));
            if(avg < lowestAverage) {
                // student has lower grade than previously tracked
                studentsWithLowestGrade.clear();
                lowestAverage = avg;
            }
            if (avg == lowestAverage) {
                studentsWithLowestGrade.add(String.valueOf(pair.getKey()));
            }
        }
        userIO.print("Lowest grade: " + lowestAverage);
        return studentsWithLowestGrade;
    }
}
