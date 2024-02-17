package Calc;

import java.util.Scanner;

public class calc{ //Main class
    public void run(){
        CC calculator;
        Scanner scanner = new Scanner(System.in);
        long num1=0, num2=0;
        char operator= ' ';
        int pref;

        System.out.println
        ("\nType 1 for addition\nType 2 for subtraction\nType 3 for multiplacation");
        System.out.println
        ("Type 4 for division\nType 5 for the power of a number\nType 6 for square root\n");
        System.out.println
        ("Type 7 for trigonometric functions(like tangent)");

        try{
            pref = scanner.nextInt();

            if(pref!=1&&pref!=2&&pref!=3&&pref!=4&&pref!=5&&pref!=6&&pref!=7){
                scanner.close();
                throw new Exception("Invalid Input");
            }

            if(pref!=5&&pref!=6&&pref!=7){
                clearConsole();
                System.out.print("\nEnter first number: ");
    
                num1 = scanner.nextLong();
    
                clearConsole();
                System.out.print("\nEnter second number: ");
                num2 = scanner.nextLong();
                clearConsole();

            } else if(pref==5) {
                clearConsole();
                System.out.print("\nEnter your number you want to raise to a power: ");
                num1 = scanner.nextLong();
                clearConsole();
                System.out.print("\nEnter the exponent: ");
                num2 = scanner.nextLong();
                clearConsole();
            } else if(pref==6){
                //Square Root
                clearConsole();
                System.out.print("Enter the number you would like to find the root of: ");
                num1 = scanner.nextLong();

                System.out.println();

                calculator = new CC(num1, true);

                System.out.print
                ("The square root of " + num1 + " is " + calculator.getAnswer() + "\n");
                System.out.println();
                scanner.close();
                return;
            } else if(pref==7){
                clearConsole();
                System.out.print("\nEnter 1 for cosign, 2 for tangent, and 3 for sine: ");

                byte prefB = scanner.nextByte();

                clearConsole();

                if(prefB!=1&&prefB!=2&&prefB!=3){
                    scanner.close();
                    throw new Exception();
                } 
                
                System.out.print("Enter your angle: ");

                byte angle = scanner.nextByte();

                calculator = new CC(angle, prefB);

                clearConsole();

                System.out.println("Answer: " + calculator.getAnswer());

                scanner.close();
                return;
            }

            switch (pref) {
                case 1:
                    operator = '+';
                case 2:
                    operator = '-';
                case 3:
                    operator = '*';
                case 4:
                    operator = '/';
                case 5:
                    operator = '^';
            }

            calculator = new CC(num1, operator, num2);
            System.out.println("\n\nAnswer: " + calculator.getAnswer() + "\n\n");

            scanner.close();
        } catch(java.util.InputMismatchException e){
            System.out.println("\n" + e + " ERROR BYE!\n");
            scanner.close();
            return;
        } catch(Exception e) {
            System.out.println(e);
            scanner.close();
            return;
        }
    scanner.close();
    }

    public static void clearConsole(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

}