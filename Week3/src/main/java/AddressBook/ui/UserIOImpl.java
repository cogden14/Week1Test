package AddressBook.ui;



import java.util.Scanner;

public class UserIOImpl implements UserIO{
    final private Scanner in = new Scanner(System.in);
    
    @Override
    public void print(String message){
        System.out.println(message); 
    }
    
    @Override
    public String readString(String prompt){
        System.out.print(prompt);
        return in.nextLine();
    }
    
    @Override
    public int readInt(String prompt){
        do{
            try{
                System.out.print(prompt);
                return Integer.parseInt(in.nextLine());
            }catch(NumberFormatException nfe){
                System.out.println("Not an integer. Please try again");
            }
        }while(true);
    }

    @Override
    public int readInt(String prompt, int min, int max){
        do{
            try{
                System.out.print(prompt);
                int x = Integer.parseInt(in.nextLine());
                if(x <= max && min <= x){
                    return x;
                } else {
                    System.out.println("Out of range. Try again");
                }
            }catch(NumberFormatException nfe){
                System.out.println("Not an integer. Please try again");
            }
        }while(true);
    }

    @Override
    public double readDouble(String prompt){
        do{
            try{
                System.out.print(prompt);
                return Double.parseDouble(in.nextLine());
            }catch(NumberFormatException nfe){
                System.out.println("Not an number. Please try again");
            }
        }while(true);
    }

    @Override
    public double readDouble(String prompt, double min, double max){
        do{
            try{
                System.out.print(prompt);
                double x = Double.parseDouble(in.nextLine());
                if(x <= max && min <= x){
                    return x;
                } else {
                    System.out.println("Out of range. Try again");
                }
            }catch(NumberFormatException nfe){
                System.out.println("Not an integer. Please try again");
            }
        }while(true);
    }

    @Override
    public float readFloat(String prompt){
        do{
            try{
                System.out.print(prompt);
                return Float.parseFloat(in.nextLine());
            }catch(NumberFormatException nfe){
                System.out.println("Not an number. Please try again");
            }
        }while(true);
    }

    @Override
    public float readFloat(String prompt, float min, float max){
        do{
            try{
                System.out.print(prompt);
                float x = Float.parseFloat(in.nextLine());
                if(x <= max && min <= x){
                    return x;
                } else {
                    System.out.println("Out of range. Try again");
                }
            }catch(NumberFormatException nfe){
                System.out.println("Not an integer. Please try again");
            }
        }while(true);
    }

    @Override
    public long readLong(String prompt){
        do{
            try{
                System.out.print(prompt);
                return Long.parseLong(in.nextLine());
            }catch(NumberFormatException nfe){
                System.out.println("Not an number. Please try again");
            }
        }while(true);
    }

    @Override
    public long readLong(String prompt, long min, long max){
        do{
            try{
                System.out.print(prompt);
                long x = Long.parseLong(in.nextLine());
                if(x <= max && min <= x){
                    return x;
                } else {
                    System.out.println("Out of range. Try again");
                }
            }catch(NumberFormatException nfe){
                System.out.println("Not an integer. Please try again");
            }
        }while(true);
    }
}
