package Day3;

public class SimpleCalcApp {
    public static void main(String[] args) {
        run();
    }
    
    public static void run() {
        SimpleCalculator calc = new SimpleCalculator();
        UserIO userIO = new UserIOImpl();
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
            
            selection = userIO.readInt("Enter a number to select operation: ", 1, 5);
            
            if(selection != 5){
                while(true){
                    try{
                        op1 = userIO.readInt("Enter the first operand: ");
                        op2 = userIO.readInt("Enter the second operand: ");
                        break;
                    }catch(NumberFormatException nfe){
                        System.out.println("Not an integer: try again");
                    }
                }
            }
            
            switch (selection) {
                case 1 -> System.out.println(op1 + " + " + op2 + " = " + calc.add(op1, op2));
                case 2 -> System.out.println(op1 + " - " + op2 + " = " + calc.subtract(op1, op2));
                case 3 -> System.out.println(op1 + " * " + op2 + " = " + calc.multiply(op1, op2));
                case 4 -> System.out.println(op1 + " / " + op2 + " = " + calc.divide(op1, op2));
                case 5 -> repeat = false;
            }
        }
        
        System.out.println("Thank you! Come again!");
    }
}
