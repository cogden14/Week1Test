package Day1;



import Day1.SimpleCalculator;
import java.util.Scanner;

public class SimpleCalcApp {
    public static void main(String[] args) {
        run();
    }
    
    public static void run() {
        SimpleCalculator calc = new SimpleCalculator();
        Scanner scan = new Scanner(System.in);
        boolean repeat = true;
        int selection = 0;
        int op1 = 0;
        int op2 = 0;
        while(repeat == true){
            System.out.println("Calculator");
            System.out.println("1) Addition");
            System.out.println("2) Subtraction");
            System.out.println("3) Multiplication");
            System.out.println("4) Division");
            System.out.println("5) Exit");
            
            while(true){
                try{
                    System.out.println("Enter a number to select operation: ");
                    selection = Integer.parseInt(scan.nextLine());
                    if(1 <= selection && 5 >= selection){
                        break;
                    }else{
                        System.out.println("Out of range: try again");
                    }
                }catch(NumberFormatException nfe){
                    System.out.println("Not an integer: try again");
                }
            }
            if(selection != 5){
                while(true){
                    try{
                        System.out.println("Enter the first operand: ");
                        op1 = Integer.parseInt(scan.nextLine());
                        System.out.println("Enter the second operand: ");
                        op2 = Integer.parseInt(scan.nextLine());
                        break;
                    }catch(NumberFormatException nfe){
                        System.out.println("Not an integer: try again");
                    }
                }
            }
            
            switch (selection) {
                case 1:
                    System.out.println(op1 + " + " + op2 + " = " + calc.add(op1, op2));
                    break;
                case 2:
                    System.out.println(op1 + " - " + op2 + " = " + calc.subtract(op1, op2));
                    break;
                case 3:
                    System.out.println(op1 + " * " + op2 + " = " + calc.multiply(op1, op2));
                    break;
                case 4:
                    System.out.println(op1 + " / " + op2 + " = " + calc.divide(op1, op2));
                    break;
                case 5:
                    repeat = false;
                    break;
            }
        }
        
        System.out.println("Thank you! Come again!");
    }
}
