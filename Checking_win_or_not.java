package Tic_Tac_Toe_console_Application;

public class Checking_win_or_not {
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
