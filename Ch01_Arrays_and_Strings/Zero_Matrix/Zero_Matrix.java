import java.util.Random;

/**
 * Algorithm to check if a matrix contains an element that is 0, if so then it will set its entire row and column to 0.
 * O(MN) time and O(1) space
 * @author Gillis Werrebrouck
 */

public class Zero_Matrix {
    public static void main(String args[]) {
        Integer M = 4, N = 4;
        if(args.length > 0) {
            M = Integer.parseInt(args[0]);
            N = M;
        }
        if(args.length > 1) {
            N = Integer.parseInt(args[1]);
        }

        Integer[][] matrix = generateNxNMatrix(M, N);
        System.out.print("Original matrix:\n");
        printMatrix(matrix);
        setZeros(matrix);
        System.out.print("After setting zeros:\n");
        printMatrix(matrix);
    }

    // generate a random MxN matrix
    private static Integer[][] generateNxNMatrix(Integer M, Integer N) {
        Integer[][] matrix = new Integer[M][N];
        Random random = new Random();

        for(Integer row = 0; row < M; row++) {
            for(Integer col = 0; col < N; col++) {
                matrix[row][col] = random.nextInt(11);
            }
        }

        return matrix;
    }

    private static void printMatrix(Integer[][] matrix) {
        for(Integer row = 0; row < matrix.length; row++) {
            System.out.print("| ");
            for(Integer col = 0; col < matrix[row].length; col++) {
                System.out.print(String.format("%3s ", matrix[row][col]));
            }
            System.out.print("|\n");
        }
        System.out.print("\n");
    }

    private static void setZeros(Integer[][] matrix) {
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        for(Integer index = 0; index < matrix.length; index++) {
            if(matrix[index][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        for(Integer index = 0; index < matrix[0].length; index++) {
            if(matrix[0][index] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        for(Integer col = 1; col < matrix.length; col++) {
            for(Integer row = 1; row < matrix[0].length; row++) {
                if(matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        for(Integer col = 1; col < matrix.length; col++) {
            for(Integer row = 1; row < matrix[0].length; row++) {
                if(matrix[0][col] == 0 || matrix[row][0] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        if(firstColHasZero) {
            for(Integer col = 0; col < matrix.length; col++) {
                matrix[0][col] = 0;
            }
        }

        if(firstColHasZero) {
            for(Integer row = 0; row < matrix[0].length; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}
