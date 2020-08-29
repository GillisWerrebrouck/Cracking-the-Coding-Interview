/**
 * Algorithm to search in a matrix where all rows and columns are sorted.
 * 
 * @author Gillis Werrebrouck
 */

public class Sorted_Matrix_Search {
    public static void main(final String args[]) {
        int[][] matrix = new int[][]{
            { 1, 2, 3, 4, 5 },
            { 6, 7, 8, 9, 10 },
            { 11, 12, 13, 14, 15 },
            { 16, 17, 18, 19, 20 },
            { 21, 22, 23, 24, 25 }
        };
        int value = 22;
        Position position = binary_matrix_search(matrix, value);
        
        if (position.row == -1 && position.col == -1) {
            System.out.println("the value " + value + " could not be found in the matrix");
        } else {
            System.out.println("the value " + value + " was found at position [" + position.row + ", " + position.col + "]");
        }
    }

    public static Position binary_matrix_search(int[][] matrix, int value) {
        return binary_matrix_search(matrix, value, new Position(0, 0), new Position(matrix.length - 1, matrix[0].length - 1));
    }

    public static Position binary_matrix_search(int[][] matrix, int value, Position top_left, Position bottom_right) {
        if (top_left.row > bottom_right.row || top_left.col > bottom_right.col) {
            return new Position(-1, -1);
        }

        int middle_row = top_left.row + (bottom_right.row - top_left.row) / 2;
        int middle_col = top_left.col + (bottom_right.col - top_left.col) / 2;
        Position middle = new Position(middle_row, middle_col);

        if (matrix[middle_row][middle_col] == value) {
            return new Position(middle_row, middle_col);
        } else if (matrix[middle_row][middle_col] > value) {
            return binary_matrix_search(matrix, value, top_left, middle);
        }
        
        Position block_1 = binary_matrix_search(matrix, value, new Position(middle_row + 1, top_left.col), bottom_right);
        Position block_2 = binary_matrix_search(matrix, value, new Position(top_left.row, middle_col + 1), new Position(middle_row, bottom_right.col));

        if (block_1.row != -1 && block_1.col != -1) {
            return block_1;
        }
        if (block_2.row != -1 && block_2.col != -1) {
            return block_2;
        }
        return new Position(-1, -1);
    }
}

class Position {
    int row;
    int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
