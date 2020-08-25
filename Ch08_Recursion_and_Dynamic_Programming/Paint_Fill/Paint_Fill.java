/**
 * Algorithm to recursively fill a screen.
 * 
 * @author Gillis Werrebrouck
 */

public class Paint_Fill {
    public static void main(final String args[]) {
        int[][] screen = new int[25][25];

        displayScreen(screen);
        fill(12, 12, screen);
        displayScreen(screen);
    }

    public static void displayScreen(int[][] screen) {
        for (int row = 0; row < screen.length; row++) {
            for (int col = 0; col < screen[row].length; col++) {
                System.out.print(Integer.toString(screen[row][col]) + ' ');
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void fill(int row, int col, int[][] screen) {
        if (screen[row][col] == 1) {
            return;
        }

        screen[row][col] = 1;

        if (0 < row) fill(row-1, col, screen);
        if (col < screen[0].length - 1) fill(row, col+1, screen);
        if (row < screen.length - 1) fill(row+1, col, screen);
        if (0 < col) fill(row, col-1, screen);
    }
}
