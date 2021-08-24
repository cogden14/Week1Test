/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibrary.ui;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author coleogden
 */
public class UserIOConsoleImpl implements UserIO{
    
    Scanner sc = new Scanner(System.in);
    
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        return Integer.parseInt(sc.nextLine());
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int value = -2000000000;
        do {
        System.out.println(prompt);
        value = Integer.parseInt(sc.nextLine());
        } while (value < min || value > max);
        return value;
    }

    @Override
    public double readDouble(String prompt) {
        while(true) {
            System.out.println(prompt);
            String str = sc.nextLine();
            try {
                double num = Double.parseDouble(str);
                return num;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number format. Please try again.");
            }
        }
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double value = -2000000000;
        do {
        System.out.println(prompt);
        value = Double.parseDouble(sc.nextLine());
        } while (value < min || value > max);
        return value;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        return Float.parseFloat(sc.nextLine());
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float value = -2000000000;
        do {
        System.out.println(prompt);
        value = Float.parseFloat(sc.nextLine());
        } while (value < min || value > max);
        return value;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        return Long.parseLong(sc.nextLine());
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long value = -2000000000;
        do {
        System.out.println(prompt);
        value = Long.parseLong(sc.nextLine());
        } while (value < min || value > max);
        return value;
    }
    
    @Override
    public void printQuizScores(ArrayList<Integer> scores) {
        scores.forEach(score -> {
            print(String.valueOf(score));
        });
    }
    
    @Override
    public void printStudentNames(ArrayList<String> names) {
        for(String name : names) {
            print(name);
        }
    }
}