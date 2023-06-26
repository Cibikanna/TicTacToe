package Tic_Tac_Toe_console_Application;

import java.util.Scanner;
import Tic_Tac_Toe_console_Application.*;

class Printing {
    public static void prt(char a[][]) {
        for (int i = 0; i < 3; i++) {
            if (i == 0)
                System.out.println("- - - - - - -");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + a[i][j] + " ");
                if (j == 2)

                {
                    System.out.println("|");
                    System.out.print("- - - - - - -");
                }
            }
            System.out.println();
        }
    }
}

class Checking_win_or_not {
    public static int check(char a[][], int r, int c, char ch) {
        char x, k = a[r][c];
        int y = 0;
        for (int i = 0; i < 3; i++) {
            if (a[i][c] != k) {
                y = 0;
                break;
            } else
                y = 1;
        }
        if (y == 1)
            return 1;
        for (int i = 0; i < 3; i++) {
            if (a[r][i] != k) {
                y = 0;
                break;
            } else
                y = 1;
        }
        if (y == 1)
            return 1;
        if (a[0][0] == k && a[1][1] == k && a[2][2] == k)
            return 1;
        if (a[0][2] == k && a[1][1] == k && a[2][0] == k)
            return 1;
        return 0;
    }
}

public class Tic_Tac_Toe extends Checking_win_or_not // main class
{

    public static void main(String[] args) {
        Printing pt = new Printing();// object for printing
        // Draw_or_not d = new Draw_or_not();//object for checking draw or not
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to tic tac toe");
        char arr[][] = new char[3][3];
        Play_Game k = new Play_Game();

        k.assign(arr);
        pt.prt(arr);
        k.play(arr);

    }
}
