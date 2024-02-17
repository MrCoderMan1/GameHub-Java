package Tic;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private char[][] board = new char[3][3];
    Random random = new Random();
    byte moveCol, moveRow;
    boolean win = false;
    boolean lose = false;
    char X = 'X';
    char O = 'O';

    public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void startBoard() {
        for (int i = 0; i < 3; i++) {
            for (int e = 0; e < 3; e++) {
                board[i][e] = ' ';
            }
        }
    }

    public void displayBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col]);
                if (col < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (row < 2) {
                System.out.println("---------");
            }
        }
    }

    public void runTicTacToe() {
        Scanner scanner = new Scanner(System.in);
        startBoard();
        while (!win && !lose) {
            displayBoard();
            System.out.println("Hello you are X");
            System.out.print("\nType the row your move will be in: ");
            try {
                moveRow = scanner.nextByte();
                if (moveRow < 1 || moveRow > 3) {
                    throw new InputMismatchException();
                }
                System.out.print("\nNow enter the column: ");
                moveCol = scanner.nextByte();
                if (moveCol < 1 || moveCol > 3) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input bye!");
                scanner.close();
                return;
            }
            if (board[moveRow - 1][moveCol - 1] == ' ') {
                board[moveRow - 1][moveCol - 1] = X;
            } else {
                System.out.println("Invalid Input, Try Again");
                continue;
            }

            if (checkWin(X)) {
                clearConsole();
                displayBoard();
                System.out.println("Congratulations! You win!");
                break;
            } else if (isBoardFull()) {
                clearConsole();
                displayBoard();
                System.out.println("It's a draw!");
                break;
            }

            // Computer's move
            int computerX, computerY;
            while (true) {
                computerX = random.nextInt(3);
                computerY = random.nextInt(3);
                if (board[computerX][computerY] == ' ') {
                    board[computerX][computerY] = 'O';
                    break;
                }
            }

            if (checkWin(O)) {
                clearConsole();
                displayBoard();
                System.out.println("Computer wins!");
                break;
            } else if (isBoardFull()) {
                clearConsole();
                displayBoard();
                System.out.println("It's a draw!");
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                scanner.close();
                return;
            }
            clearConsole();
        }
        scanner.close();
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        else if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }
}