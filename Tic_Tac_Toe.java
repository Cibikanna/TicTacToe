import java.util.Scanner;

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
