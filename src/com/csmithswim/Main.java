package com.csmithswim;
import org.w3c.dom.ls.LSOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[][] twoDArray = new char[3][3];
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                twoDArray[i][j] = input.charAt(counter);
                counter++;
            }
        }

        boolean gameInProgress = true;
        int x = 0;
        int o = 0;
        int spaces = 0;
        int xWins = 0;
        int oWins = 0;
        if (twoDArray[0][0] + twoDArray[1][1] + twoDArray[2][2] == 264) {
            xWins++;
        }
        if (twoDArray[0][0] + twoDArray[1][1] + twoDArray[2][2] == 237) {
            oWins++;
        }
        if (twoDArray[0][2] + twoDArray[1][1] + twoDArray[2][0] == 264){
            xWins++;
        }
        if (twoDArray[0][2] + twoDArray[1][1] + twoDArray[2][0] == 237){
            oWins++;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (twoDArray[i][j] == 'X') {
                    x++;
                }
                if (twoDArray[i][j] == 'O') {
                    o++;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                //Rows
                if (twoDArray[i][j] + twoDArray[i][j+1] + twoDArray[i][j+2] == 264) {
                    xWins++;
                    break;
                }
                if (twoDArray[i][j] + twoDArray[i][j+1] + twoDArray[i][j+2] == 237) {
                    oWins++;
                    break;
                }
                //Columns
                if (twoDArray[j][i] + twoDArray[j+1][i] + twoDArray[j+2][i] == 264) {
                    xWins++;
                    break;
                }
                if (twoDArray[j][i] + twoDArray[j+1][i] + twoDArray[j+2][i] == 237) {
                    oWins++;
                    break;
                }
                if (twoDArray[i][j] == '_'){
                    spaces++;
                }
            }
        }

        if (xWins == 1 && oWins == 0) {
            System.out.println("X wins");
        }
        else if (oWins == 1 && xWins == 0) {
            System.out.println("O wins");
        }
        else if (xWins < 1 && oWins < 1 & spaces > 0 && Math.abs(x-o) <= 1) {
            System.out.println("Game not finished");
        }
        else if (x + o == 9) {
            System.out.println("Draw");
        }
        else if (xWins >= 1 && oWins >= 1 || Math.abs(x-o) > 1) {
            System.out.println("Impossible");
        }

        System.out.println("---------");
        for (int i = 0; i < input.length()-1; i += 3) {
            System.out.println("| " + input.charAt(i) + " " + input.charAt(i + 1) + " " + input.charAt(i + 2)+ " |");
        }
        System.out.println("---------");
    }
}