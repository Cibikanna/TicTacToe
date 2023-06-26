package Tic_Tac_Toe_console_Application;

public class Printing {
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