import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        //starting with a 3x3 board
        char[][] board = new char[3][3];

        //initially we must have empty spaces
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        //initially say player X is playing
        char player = 'X';
        boolean gameOver = false;

        Scanner sc = new Scanner(System.in);

        while (!gameOver) {
            //printing the board first
            printBoard(board);
            System.out.print("Player " + player + " enter: ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (board[row][col] == ' ') {
                //place the element
                board[row][col] = player;
                if (haveWon(board, player)) {
                    printBoard(board); // Print board before announcing winner
                    System.out.println();
                    System.out.println("Player " + player + " has won!");
                    System.out.println();
                    gameOver = true;
                } else if (isFull(board)) {
                    printBoard(board); // Print board before announcing draw
                    System.out.println();
                    System.out.println("It's a draw!");
                    System.out.println();
                    gameOver = true;
                } else {
//                    if (player == 'X') {
//                        player = 'O';
//                    } else {
//                        player = 'X';
//                    }

                    player = (player=='X')?'O' : 'X';
                }

            } else {
                System.out.println("Invalid move");

            }
        }

        printBoard(board);
    }

    static void printBoard(char[][] board) {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            //after every row, print a new line
            System.out.println();

            if (row < board.length - 1) {
                System.out.println("---------------");
            }
        }

    }

    static boolean haveWon(char[][] board, char player) {
        //checking horizontally
        for (int row = 0; row < board.length; row++) {
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }

            //checking vertically
            for (int col = 0; col < board[row].length; col++) {
                if (board[0][col] == player && board[1][col] == player && board[2][col] == player){
                    return true;
                }
            }

            //checking diagonally
            if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
                return true;
            }
            if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
                return true;
            }
        }

        return false;
    }

    static boolean isFull(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if(board[row][col] == ' '){
                    //if board is empty still
                    return false;
                }
            }
        }

        //else board is actually full
        return true;

    }
}
