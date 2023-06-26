package Tic_Tac_Toe_console_Application;

//import Tic_Tac_Toe_console_Application.*;

class Draw_or_not // checking for draw or not
{
    public static int check(char[][] a) {
        int flag = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (Character.isDigit(a[i][j]))
                    flag = 1;

        if (flag == 1)
            return 1;
        return 0;
    }
}
