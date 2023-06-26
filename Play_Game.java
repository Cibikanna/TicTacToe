package Tic_Tac_Toe_console_Application;

import java.util.Scanner;
//import Tic_Tac_Toe_console_Application.*;

class Play_Game extends Printing {
    public static void assign(char arr[][]) {
        int t = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = (char) (t + '0');
                t++;
            }
        }
    }

    public static int restart() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 0 to exit 1 to restart:");
        int r = sc.nextInt();
        return r;
    }

    public static void play(char arr[][]) {
        Draw_or_not d = new Draw_or_not();
        Checking_win_or_not l = new Checking_win_or_not();
        Scanner sc = new Scanner(System.in);
        int o = 0;
        char ch = ' ';
        char sp[][] = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                sp[i][j] = ' ';
        }
        System.out.println("X go first");
        while (true) {
            System.out.print("Enter the point:");
            int point = sc.nextInt();
            if (point < 0 || point > 10) {
                System.out.println("Invalid Point! Enter the valid point");
                continue;
            }
            int row = 0, col = 0;

            char c = (char) (point + '0');
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (arr[i][j] == c) {
                        row = i;
                        col = j;
                    }
                }
            }
            if (o == 0) {
                ch = 'x';
                o = 1;
            } else if (o == 1) {
                ch = 'o';
                o = 0;
            }
            if (Character.isDigit(arr[row][col])) {
                arr[row][col] = ch;
                sp[row][col] = ch;
            } else {
                System.out.println("Element already exist");
                continue;
            }

            int flag = l.check(arr, row, col, ch);
            int f = d.check(arr);
            prt(arr);
            System.out.println();
            prt(sp);
            if (flag == 1) {
                System.out.println(ch + " Wins!");
                int re_start = restart();
                if (re_start == 0)
                    break;
                else {
                    assign(arr);
                    continue;
                }
            }
            if (f == 0) {
                System.out.println("Match Draws");
                int re_start = restart();
                if (re_start == 0)
                    break;
                else {
                    assign(arr);
                    continue;
                }
            }

        }
    }
}
