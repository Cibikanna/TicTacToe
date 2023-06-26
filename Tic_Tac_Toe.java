package Tic_Tac_Toe_console_Application;

import java.util.Scanner;
import Tic_Tac_Toe_console_Application.*;

public class Tic_Tac_Toe extends Checking_win_or_not // main class
{

    public static void main(String[] args) {
        Printing pt = new Printing();// object for printing
        Draw_or_not d = new Draw_or_not();// object for checking draw or not
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to tic tac toe");
        char arr[][] = new char[3][3];
        Play_Game k = new Play_Game();

        k.assign(arr);
        pt.prt(arr);
        k.play(arr);

    }
}
