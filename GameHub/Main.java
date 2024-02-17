import java.util.InputMismatchException;
import java.util.Scanner;

import Calc.calc;
import Tic.TicTacToe;
import Timer.TimerMain;

class Main{
    public static void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        byte input;

        try{
            System.out.println("\nHello!");
            System.out.print("\nEnter 1 to play Tic-Tac-Toe, 2 for a timer, and 3 for a Calculator: ");
            input = scanner.nextByte();
            if(input!=1&&input!=2&&input!=3){
                scanner.close();
                throw new InputMismatchException("Invalid Input");
            }
        } catch(InputMismatchException e){
            System.out.println("\n " + e + "\n");
            scanner.close();
            return;
        }
        switch (input) {
            case 1:
                var ticTacToe = new TicTacToe();
                clearConsole();
                ticTacToe.runTicTacToe();

                scanner.close();
                return;
            case 2:
                var timer = new TimerMain();
                clearConsole();
                timer.startTimer();

                scanner.close();
                return;
            case 3:
                var Calculator = new calc();
                clearConsole();
                Calculator.run();

                scanner.close();
                return;
        }
        scanner.close();
    }
}