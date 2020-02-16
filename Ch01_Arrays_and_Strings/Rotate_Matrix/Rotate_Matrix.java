import java.util.Random;

/**
 * Algorithm to rotate an image represented as a NxN matrix, where each cell is 4 bytes.
 * @author Gillis Werrebrouck
 */

public class Rotate_Matrix {
    public static void main(String args[]) {
        Integer N = args.length > 0 ? Integer.parseInt(args[0]) : 4;

        Integer[][] matrix = GenerateNxNMatrix(N);
        System.out.print("Original matrix:\n");
        PrintMatrix(matrix);
        RotateNxNMatrix(matrix);
        System.out.print("Rotated matrix (90 degrees clockwise):\n");
        PrintMatrix(matrix);
    }

    // generate a random NxN matrix
    private static Integer[][] GenerateNxNMatrix(Integer N) {
        Integer[][] matrix = new Integer[N][N];
        Random random = new Random();

        for(Integer row = 0; row < N; row++) {
            for(Integer col = 0; col < N; col++) {
                matrix[row][col] = random.nextInt(100) + 1;
            }
        }

        return matrix;
    }

    private static void PrintMatrix(Integer[][] matrix) {
        for(Integer row = 0; row < matrix.length; row++) {
            System.out.print("| ");
            for(Integer col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + (col == matrix[0].length-1 ? "" : "\t"));
            }
            System.out.print(" |\n");
        }
        System.out.print("\n");
    }

    private static boolean RotateNxNMatrix(Integer[][] matrix) {
        if(matrix.length == 0 || matrix.length != matrix[0].length) {
            return false;
        }

        Integer N = matrix.length;

        for(Integer layer = 0; layer < N/2; layer++) {
            Integer start = layer;
            Integer end = N - 1 - layer;

            for(Integer i = start; i < end; i++) {
                // right to temp
                Integer temp = matrix[i][end];
                // top to right
                matrix[i][end] = matrix[start][i];
                // left to top
                matrix[start][i] = matrix[N-1-i][start];
                // bottom to left
                matrix[N-1-i][start] = matrix[end][N-1-i];
                // right (temp) to bottom
                matrix[end][N-1-i] = temp;
            }
        }

        return true;
    }
}
